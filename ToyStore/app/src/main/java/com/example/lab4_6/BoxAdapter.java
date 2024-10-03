package com.example.lab4_6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BoxAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Product> objects;
    View footer;
    TextView totalItemsTextView;

    BoxAdapter(Context context, ArrayList<Product> products, View footer, TextView totalItemsTextView) {
        this.context = context;
        objects = products;
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.footer = footer;
        this.totalItemsTextView = totalItemsTextView;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item, parent, false);
        }

        Product p = getProduct(position);
        ((TextView) view.findViewById(R.id.id)).setText(String.valueOf(p.id));
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
        ((TextView) view.findViewById(R.id.tvPrice)).setText(p.price + "");
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.imageResource);

        CheckBox cbBuy = view.findViewById(R.id.cbBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.isChecked);

        return view;
    }

    Product getProduct(int position) {
        return (Product) getItem(position);
    }

    ArrayList<Product> getBox() {
        ArrayList<Product> box = new ArrayList<>();
        for (Product p: objects) {
            if (p.isChecked)
                box.add(p);
        }
        return box;
    }

    int getTotalItems() {
        int totalItems = 0;
        for (Product p: objects) {
            if (p.isChecked)
                totalItems++;
        }
        return totalItems;
    }

    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getProduct((Integer) buttonView.getTag()).isChecked = isChecked;
            totalItemsTextView.setText("Total items: " + getTotalItems());
        }
    };
}