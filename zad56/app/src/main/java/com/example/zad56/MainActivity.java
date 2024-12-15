package com.example.zad56;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView polub;
    private int ilosc_polub = 0;
    private TextView show_user;
    private TextView info;
    private EditText mail;
    private EditText password;
    private EditText p_password;
    private Button confirm;
    private Button like;
    private Button delete;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        p_password = findViewById(R.id.p_password);
        info = findViewById(R.id.info);
        show_user = findViewById(R.id.show_user);
        polub = findViewById(R.id.polub);
        confirm = findViewById(R.id.confirm);
        like = findViewById(R.id.like);
        delete = findViewById(R.id.delete);


        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilosc_polub++;
                polub.setText(String.valueOf(ilosc_polub) + " polubień");
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ilosc_polub--;
                if (ilosc_polub < 0) {
                    ilosc_polub = 0;
                }
                polub.setText(String.valueOf(ilosc_polub) + " polubień");
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_input = mail.getText().toString().trim();
                String pass_input = password.getText().toString().trim();
                String r_pass_input = p_password.getText().toString().trim();

                if (email_input.isEmpty()) {
                    info.setText("Pole 'Podaj email' nie może być puste");
                    return;
                }
                if (pass_input.isEmpty()) {
                    info.setText("Pole 'Hasło' nie może być puste");
                    return;
                }
                if (r_pass_input.isEmpty()) {
                    info.setText("Pole 'Powtórz hasło' nie może być puste");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email_input).matches()) {
                    info.setText("Niepoprawny zapis emaila");
                    return;
                }
                if (!r_pass_input.equals(pass_input)) {
                    info.setText("Hasło musi się powtarzać");
                    return;
                }
                if (!email_input.isEmpty() && !pass_input.isEmpty() && !r_pass_input.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email_input).matches() && r_pass_input.equals(pass_input)) {
                    user = email_input;
                    info.setText("Zarejestrowano " + email_input);
                }
            }
        });


        show_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user != null && !user.isEmpty()) {
                    info.setText("Ostatnio zarejestrowany email to " + user);
                } else {
                    info.setText("Brak zarejestrowanego użytkownika");
                }
            }
        });
    }
}

