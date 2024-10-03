package com.example.lab4_6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<>();
    BoxAdapter boxAdapter;
    View footer, header;
    TextView totalItemsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMain = findViewById(R.id.lvMain);
        header = createHeader("Интернет-магазин игрушек");
        footer = createFooter("footer");

        fillData();
        boxAdapter = new BoxAdapter(this, products, footer, totalItemsTextView);
        lvMain.addHeaderView(header);
        lvMain.addFooterView(footer);
        lvMain.setAdapter(boxAdapter);

    }

    View createHeader(String text) {
        View v = getLayoutInflater().inflate(R.layout.header, null);
        ((TextView) v.findViewById(R.id.tvText)).setText(text);
        return v;
    }

    View createFooter(String text) {
        View v = getLayoutInflater().inflate(R.layout.footer, null);
        totalItemsTextView = v.findViewById(R.id.total_items_text_view);
        return v;
    }

    void fillData() {
        products.add(new Product(0, "Плюшевый кот", 750,R.drawable.one, false));
        products.add(new Product(1, "Мини капибара", 500,R.drawable.two, false));
        products.add(new Product(2, "Игрушечный пупс", 1500, R.drawable.three, false));
//        products.add(new Product(3, "Игрушечный пупс 2", 700, R.drawable.four, false));
//        products.add(new Product(4, "Русалка", 870,R.drawable.five, false));
//        products.add(new Product(5, "Мягкая игрушка мишка", 500, R.drawable.six, false));
    }

    public void showResult(View v) {
        ArrayList<Product> checkedProducts = boxAdapter.getBox();
        Intent intent = new Intent(this, CartActivity.class);
        intent.putExtra("checked_products", checkedProducts);
        startActivity(intent);
    }
}