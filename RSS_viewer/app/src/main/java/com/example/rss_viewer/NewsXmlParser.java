package com.example.rss_viewer;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.StringReader;
import java.util.ArrayList;

public class NewsXmlParser {
    private final ArrayList<NewsItem> newsItems;

    public NewsXmlParser() {
        newsItems = new ArrayList<>();
    }

    public ArrayList<NewsItem> getNewsItems() {
        return newsItems;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        NewsItem currentNewsItem = null;
        boolean inEntry = false;
        String textValue = "";
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("item".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentNewsItem = new NewsItem();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            if ("item".equalsIgnoreCase(tagName)) {
                                newsItems.add(currentNewsItem);
                                inEntry = false;
                            } else if ("title".equalsIgnoreCase(tagName)) {
                                currentNewsItem.setTitle(textValue);
                            } else if ("link".equalsIgnoreCase(tagName)) {
                                currentNewsItem.setLink(textValue);
                            } else if ("description".equalsIgnoreCase(tagName)) {
                                currentNewsItem.setDescription(textValue);
                            } else if ("pubDate".equalsIgnoreCase(tagName)) {
                                currentNewsItem.setPubDate(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}
