package com.example.domek_w_gorach;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button like;
    private Button save;
    private Button delete;
    private int ilosc = 0;
    private TextView polubienie;
    private View linia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        like = findViewById(R.id.like);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        polubienie = findViewById(R.id.polubienie);
        linia = findViewById(R.id.linia);

        View linia = findViewById(R.id.linia);
        linia.setBackgroundColor(Color.GRAY);


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilosc++;
                polubienie.setText(String.valueOf(ilosc));
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ilosc > 0) {
                    ilosc--;
                    polubienie.setText(String.valueOf(ilosc));
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Zapisano stan: " + ilosc);
            }
        });
    }
}



