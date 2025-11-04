package com.example.lekcja13_sharedpreferences4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "Lekcja13_SharedPreferences4";
    private static final String WEIGHT_KEY = "Weight";
    private static final String HEIGHT_KEY = "Height";

    private EditText weightInput, heightInput;
    private TextView resultText;
    private Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        calcButton = findViewById(R.id.calcButton);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        weightInput.setText(prefs.getString(WEIGHT_KEY, ""));
        heightInput.setText(prefs.getString(HEIGHT_KEY, ""));

        calcButton.setOnClickListener(v -> {
            String w = weightInput.getText().toString().trim();
            String h = heightInput.getText().toString().trim();

            if (!w.isEmpty() && !h.isEmpty()) {
                double weight = Double.parseDouble(w);
                double height = Double.parseDouble(h) / 100.0;
                double bmi = weight / (height * height);
                resultText.setText(String.format("Twoje BMI: %.2f", bmi));
            } else {
                resultText.setText("Podaj wagę i wzrost!");
            }


        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(WEIGHT_KEY, weightInput.getText().toString());
        editor.putString(HEIGHT_KEY, heightInput.getText().toString());
        editor.apply();
    }
}
