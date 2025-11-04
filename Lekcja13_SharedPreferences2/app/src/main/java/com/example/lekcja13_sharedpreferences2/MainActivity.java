package com.example.lekcja13_sharedpreferences2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "lekcja13_SharedPreferences2";
    private static final String SWITCH_KEY = "Switchinputdata";

    private Switch inputSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSwitch = findViewById(R.id.inputSwitch);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean state = prefs.getBoolean(SWITCH_KEY, false);
        inputSwitch.setChecked(state);

        inputSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                editor.putBoolean(SWITCH_KEY, isChecked);
                editor.apply();


            }
        });
    }
}

