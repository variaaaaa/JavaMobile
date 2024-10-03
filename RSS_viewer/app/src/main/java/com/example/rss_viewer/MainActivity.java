package com.example.rss_viewer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rss_viewer.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.contentView.setText("Загрузка...");
        new Thread(new Runnable() {
            public void run() {
                try {
                    String content = download(getResources().getString(R.string.xml_addr));
                    binding.recyclerview.post(new Runnable() {
                        public void run() {
                            NewsXmlParser parser = new NewsXmlParser();
                            if (parser.parse(content)) {
                                NewsAdapter adapter = new NewsAdapter(parser.getNewsItems());
                                binding.recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                binding.recyclerview.setAdapter(adapter);
                                binding.contentView.setText("Загружено объектов: " + adapter.getItemCount());
                            }
                        }
                    });
                } catch (IOException ex) {
                    binding.contentView.post(new Runnable() {
                        public void run() {
                            binding.contentView.setText("Ошибка: " + ex.getMessage());
                        }
                    });
                }
            }
        }).start();
    }

    private String download(String urlPath) throws IOException {
        StringBuilder xmlResult = new StringBuilder();
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpsURLConnection) url.openConnection();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                xmlResult.append(line);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return xmlResult.toString();
    }
}
