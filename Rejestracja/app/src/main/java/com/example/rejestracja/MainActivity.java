package com.example.rejestracja;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailinput;
    private EditText hasloinput;
    private EditText powhasloinput;
    private Button confirm;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailinput = findViewById(R.id.emailinput);
        EditText hasloinput = findViewById(R.id.hasloinput);
        EditText powhasloinput = findViewById(R.id.powhasloinput);
        Button confirm = findViewById(R.id.confirm);
        TextView info = findViewById(R.id.info);

        info.setText("Autor: Twoje Imię i Nazwisko");

        confirm.setOnClickListener(v -> {
            String email = emailinput.getText().toString();
            String password = hasloinput.getText().toString();
            String repeatPassword = powhasloinput.getText().toString();

            if(TextUtils.isEmpty(email)){
                info.setText("Wypelnij pole E-mail!");
                return;
            }

            if (TextUtils.isEmpty(email) || !email.contains("@")) {
                info.setText("Nieprawidłowy adres e-mail");
                return;
            }
            if(TextUtils.isEmpty(password)){
                info.setText("Wypelnij pole Haslo");
                return;
            }
            if(TextUtils.isEmpty(repeatPassword)){
                info.setText("Wypelnij pole Powtorz haslo");
                return;
            }

            if (!password.equals(repeatPassword)) {
                info.setText("Hasła się różnią");
                return;
            }


            info.setText("Witaj " + email);
        });
    }
}
