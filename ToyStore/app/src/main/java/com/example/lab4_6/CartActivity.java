package com.example.lab4_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>();
    CartAdapter cartAdapter;

    View footer2, header;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);
        ListView lvMain = findViewById(R.id.lvMain);

        header = createHeader("Интернет-магазин игрушек");
        footer2 = createFooter("footer");

        fillData();
        cartAdapter = new CartAdapter(this, products, footer2, total);
        lvMain.addHeaderView(header);
        lvMain.addFooterView(footer2);
        lvMain.setAdapter(cartAdapter);
    }

    View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.tvText)).setText(text);

        return v;
    }

    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer2, null);
        total = v.findViewById(R.id.total_items_text_view);
        return v;
    }


    void fillData() {
        products = (ArrayList<Product>) getIntent().getSerializableExtra("checked_products");
    }

    public void showResult(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}