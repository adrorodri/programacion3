package com.programacion3.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adro_ on 4/19/2018.
 */

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Product> productList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.recyclerView);

        for (int i = 0; i < 10; i++) {
            productList.add(new Product(i, i * 3.0, 20 - i, "Descripcion " + String.valueOf(i), R.drawable.pollito));
        }

        // Create RecyclerView adapter
        ProductsRecyclerAdapter adapter = new ProductsRecyclerAdapter(this, productList);

        // Create and set Layout manager:
        // LinearLayoutManager => Linear
        // StaggeredGridLayoutManager => Like Pinterest
        // GridLayoutManager => Grid

        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        // Set adapter
        recyclerView.setAdapter(adapter);
    }
}
