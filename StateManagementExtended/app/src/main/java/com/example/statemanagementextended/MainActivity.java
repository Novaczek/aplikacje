package com.example.statemanagementextended;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "licznik_k";
    private static final String STATE_CHECKBOX = "check";
    private static final String STATE_SWITCH = "tryb";
    private static final String STATE_INPUT = "text";

    private TextView text;
    private EditText name;
    private String name_input;
    private Button btn;
    private Button btn2;
    private TextView licznik;
    private TextView stan_check;
    private Switch tryb;
    private CheckBox stan;
    private int licznik_k = 0;
    private boolean stan_checkbox;
    private boolean stan_switch;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.buttonIncrement);
        btn2 = findViewById(R.id.buttonIncrement2);
        licznik = findViewById(R.id.textViewCount);
        stan_check = findViewById(R.id.textView);
        stan = findViewById(R.id.checkBox);
        tryb = findViewById(R.id.switch2);
        layout = findViewById(R.id.main);
        name = findViewById(R.id.editText1);
        text = findViewById(R.id.text);

        if (savedInstanceState != null) {
            name_input = savedInstanceState.getString(STATE_INPUT);
            licznik_k = savedInstanceState.getInt(KEY_COUNT);
            stan_switch = savedInstanceState.getBoolean(STATE_SWITCH);
            stan_checkbox = savedInstanceState.getBoolean(STATE_CHECKBOX);
        }

        updateText();
        updateCountText();
        updateSwitchState();
        updateCheckState();

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_input = name.getText().toString().trim();
                text.setText(name_input);
            }
        });


        tryb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stan_switch = isChecked;
            if (isChecked) {
                tryb.setText("tryb ciemny");
                layout.setBackgroundColor(Color.BLACK);
                Toast.makeText(MainActivity.this, "Zmieniono tryb na ciemny", Toast.LENGTH_SHORT).show();
            } else {
                tryb.setText("tryb jasny");
                layout.setBackgroundColor(Color.WHITE);
                Toast.makeText(MainActivity.this, "Zmieniono tryb na jasny", Toast.LENGTH_SHORT).show();
            }
        });

        stan.setOnCheckedChangeListener((buttonView, isChecked) -> {
            stan_checkbox = isChecked;
            updateCheckState();
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznik_k++;
                updateCountText();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, licznik_k);
        outState.putBoolean(STATE_CHECKBOX, stan_checkbox);
        outState.putBoolean(STATE_SWITCH, stan_switch);
        outState.putString(STATE_INPUT, name_input);
    }


    private void updateText() {
        text.setText(name_input);
    }


    private void updateCountText() {
        licznik.setText("Liczba: " + licznik_k);
    }


    private void updateCheckState() {
        if (stan_checkbox) {
            stan_check.setText("CheckBox zaznaczony");
        } else {
            stan_check.setText("CheckBox odznaczony");
        }
    }


    private void updateSwitchState() {
        tryb.setChecked(stan_switch);
        if (stan_switch) {
            tryb.setText("tryb ciemny");
            layout.setBackgroundColor(Color.BLACK);
        } else {
            tryb.setText("tryb jasny");
            layout.setBackgroundColor(Color.WHITE);
        }
    }
}
