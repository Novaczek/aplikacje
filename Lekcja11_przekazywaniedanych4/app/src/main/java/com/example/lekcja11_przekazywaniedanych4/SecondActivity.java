package com.example.lekcja11_przekazywaniedanych4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultText = findViewById(R.id.resultText);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_NAME)) {
            String name = intent.getStringExtra(MainActivity.EXTRA_NAME);
            int age = intent.getIntExtra(MainActivity.EXTRA_AGE, 0);
            resultText.setText("Imię: " + name + ", Wiek: " + age);
        } else {
            resultText.setText("Brak danych do wyświetlenia");
        }
    }
}