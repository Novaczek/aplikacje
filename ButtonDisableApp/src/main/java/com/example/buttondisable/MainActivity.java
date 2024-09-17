package com.example.buttondisable;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttondisable;
    private Button buttonenable;
    private int liczba=0;
    private TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttondisable =findViewById(R.id.button);
        buttonenable = findViewById(R.id.button2);
        hello = findViewById(R.id.hello);

        buttondisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttondisable.setEnabled(false);
                buttondisable.setText("disable");
                liczba=liczba+1;
                hello.setText("liczba kliknięć:"+ liczba);
            }
        });
        buttonenable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttondisable.setEnabled(true);
                buttondisable.setText("enable");
            }
        });

    }

}





