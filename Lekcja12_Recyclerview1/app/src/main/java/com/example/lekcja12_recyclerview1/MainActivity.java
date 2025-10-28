package com.example.lekcja12_recyclerview1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Polska"));
        countries.add(new Country("Niemcy"));
        countries.add(new Country("Nigeria"));
        countries.add(new Country("Hiszpania"));
        countries.add(new Country("Włochy"));
        countries.add(new Country("Kongo"));
        countries.add(new Country("Czechy"));
        countries.add(new Country("Japonia"));
        countries.add(new Country("USA"));
        countries.add(new Country("Arabia Saudyjska"));

        CountryAdapter adapter = new CountryAdapter(countries);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    }
