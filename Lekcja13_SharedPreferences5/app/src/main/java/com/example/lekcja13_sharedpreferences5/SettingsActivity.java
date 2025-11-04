package com.example.lekcja13_sharedpreferences5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "SettingsPrefs";
    private static final String NAME_KEY = "UserName";
    private static final String NOTIFY_KEY = "Notifications";

    private EditText nameInput;
    private Switch notifySwitch;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        nameInput = findViewById(R.id.nameInput);
        notifySwitch = findViewById(R.id.notifySwitch);
        saveButton = findViewById(R.id.saveButton);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        nameInput.setText(prefs.getString(NAME_KEY, ""));
        notifySwitch.setChecked(prefs.getBoolean(NOTIFY_KEY, false));

        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
            editor.putString(NAME_KEY, nameInput.getText().toString());
            editor.putBoolean(NOTIFY_KEY, notifySwitch.isChecked());
            editor.apply();

            Toast.makeText(this, "Ustawienia zapisane!", Toast.LENGTH_SHORT).show();

        });
    }
}
