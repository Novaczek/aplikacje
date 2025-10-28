package com.example.lekcja12_recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Telefon Samsung", 2999.99f));
        productList.add(new Product("Laptop HP", 4599.00f));
        productList.add(new Product("Konsola PS5", 1899.50f));
        productList.add(new Product("Telefon Iphone 15", 1299.99f));
        productList.add(new Product("Słuchawki JBL", 349.49f));
        productList.add(new Product("Monitor Legion", 899.00f));
        productList.add(new Product("Mysz Logitech", 159.99f));
        productList.add(new Product("Klawiatura steelseries", 499.00f));
        productList.add(new Product("Tablet Huawei", 1149.00f));
        productList.add(new Product("Drukarka HP", 699.00f));


        ProductAdapter adapter = new ProductAdapter(productList);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
