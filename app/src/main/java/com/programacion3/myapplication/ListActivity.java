package com.programacion3.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;

    String[] stringArray = {"1", "2", "3", "4", "5", "6", "7", "8"};
    List<Product> productList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        // Array Adapter Example
//        ArrayAdapter adapter =
//                new ArrayAdapter(this, R.layout.layout_list_item, R.id.textViewItem, stringArray);
//        listView.setAdapter(adapter);

        for(int i = 0; i<10; i++) {
            productList.add(new Product(i, i*3.0, 20-i, "Descripcion " + String.valueOf(i), R.drawable.pollito));
        }

        ProductsAdapter adapter = new ProductsAdapter(this, productList);
        listView.setAdapter(adapter);
    }


}
