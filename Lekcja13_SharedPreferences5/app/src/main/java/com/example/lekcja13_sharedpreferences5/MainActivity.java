package com.example.lekcja13_sharedpreferences5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SettingsPrefs";
    private static final String NAME_KEY = "UserName";
    private static final String NOTIFY_KEY = "Notifications";

    private TextView welcomeText;
    private Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeText = findViewById(R.id.welcomeText);
        settingsButton = findViewById(R.id.settingsButton);

        loadSettings();

        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadSettings();
    }
    private void loadSettings() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name = prefs.getString(NAME_KEY, "gościu");
        boolean notifications = prefs.getBoolean(NOTIFY_KEY, false);

        welcomeText.setText("Witaj, " + name + "!");
        if (notifications) {
            welcomeText.append("\nPowiadomienia: włączone");
        } else {
            welcomeText.append("\nPowiadomienia: wyłączone");
        }
    }
}
