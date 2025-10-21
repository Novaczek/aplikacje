package com.example.lekcja11_przekazywaniedanych2;


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
        int a = intent.getIntExtra(MainActivity.EXTRA_NUM1, 0);
        int b = intent.getIntExtra(MainActivity.EXTRA_NUM2, 0);

        int sum = a + b;
        resultText.setText("Wynik dodawania: " + sum);
    }
}
