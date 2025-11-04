package com.example.lekcja13_sharedpreferences3;


import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "Lekcja13_SharedPreferences3";
    private static final String LAUNCH_COUNT_KEY = "LaunchCounter";

    private TextView launchCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchCounter = findViewById(R.id.launchCounter);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int count = prefs.getInt(LAUNCH_COUNT_KEY, 0);
        count++;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(LAUNCH_COUNT_KEY, count);
        editor.apply();

        launchCounter.setText("Aplikacja uruchomiona: " + count + " razy");
    }
}
