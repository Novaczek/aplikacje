package com.example.lekcja11_przekazywaniedanych5;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView premiumStatusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        premiumStatusText = findViewById(R.id.premiumStatusText);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MainActivity.EXTRA_PREMIUM)) {
            boolean isPremium = intent.getBooleanExtra(MainActivity.EXTRA_PREMIUM, false);
            if (isPremium) {
                premiumStatusText.setText("Ustawienia premium: Włączone");
            } else {
                premiumStatusText.setText("Ustawienia premium: Wyłączone");
            }

        } else {

            premiumStatusText.setText("Brak informacji o ustawieniach premium.");
        }
    }
}