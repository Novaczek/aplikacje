package com.example.gra_w_koci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rzut;
    private Button resetWynik;
    private TextView kostk1, kostk2, kostk3, kostk4, kostk5, kostk6;
    private TextView wynikLos, wynikGry, liczbaRzutów;

    private int liczbaRzut = 0;
    private int sumaGry = 0;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzut = findViewById(R.id.rzut);
        resetWynik = findViewById(R.id.reset_wynik);

        kostk1 = findViewById(R.id.kostk1);
        kostk2 = findViewById(R.id.kostk2);
        kostk3 = findViewById(R.id.kostk3);
        kostk4 = findViewById(R.id.kostk4);
        kostk5 = findViewById(R.id.kostk5);
        kostk6 = findViewById(R.id.kostk6);

        wynikLos = findViewById(R.id.wynik_los);
        wynikGry = findViewById(R.id.wynik_gry);
        liczbaRzutów = findViewById(R.id.liczba_rzut);

        random = new Random();

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        resetWynik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void rollDice() {
        liczbaRzut++;
        liczbaRzutów.setText("Liczba rzutów: " + liczbaRzut);


        int[] wynikiKości = new int[6];
        wynikiKości [0] = random.nextInt(6) + 1;
        wynikiKości [1] = random.nextInt(6) + 1;
        wynikiKości [2] = random.nextInt(6) + 1;
        wynikiKości [3] = random.nextInt(6) + 1;
        wynikiKości [4] = random.nextInt(6) + 1;
        wynikiKości [5] = random.nextInt(6) + 1;

        kostk1.setText(String.valueOf(wynikiKości [0]));
        kostk2.setText(String.valueOf(wynikiKości [1]));
        kostk3.setText(String.valueOf(wynikiKości [2]));
        kostk4.setText(String.valueOf(wynikiKości [3]));
        kostk5.setText(String.valueOf(wynikiKości [4]));
        kostk6.setText(String.valueOf(wynikiKości [5]));


        HashSet<Integer> unikalneWyniki = new HashSet<>();
        int sumaRzutu = 0;
        for (int wynik : wynikiKości) {
            if (unikalneWyniki.add(wynik)) {
                sumaRzutu += wynik;
            }
        }


        wynikLos.setText("Wynik tego losowania: " + sumaRzutu);
        sumaGry += sumaRzutu;
        wynikGry.setText("Wynik gry: " + sumaGry);
    }

    private void resetGame() {

        kostk1.setText("?");
        kostk2.setText("?");
        kostk3.setText("?");
        kostk4.setText("?");
        kostk5.setText("?");
        kostk6.setText("?");

        liczbaRzut = 0;
        sumaGry = 0;

        liczbaRzutów.setText("Liczba rzutów: " + liczbaRzut);
        wynikLos.setText("Wynik tego losowania: 0");
        wynikGry.setText("Wynik gry: 0");
    }
}
