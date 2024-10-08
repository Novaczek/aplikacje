package com.example.formvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editnumberphone;
    private EditText editTextpassword;
    private EditText editTextpassword2;
    private Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editnumberphone = findViewById(R.id.editnumberphone);
        editTextpassword = findViewById(R.id.editTextpassword);
        editTextpassword2 = findViewById(R.id.editTextpassword2);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editnumberphone.getText().toString().trim();
                String password = editTextpassword.getText().toString().trim();
                String password2 = editTextpassword2.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz podać imię", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz podać nazwisko", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz podać email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz podać numer telefonu", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz podać hasło", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "musisz powtórzyć hasło", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (phone.length() != 9) {
                    Toast.makeText(MainActivity.this, "numer telefonu musi posiadać 9 cyfr", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Wprowadź poprawny adres e-mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(MainActivity.this, "hasło musi posiadać co najmniej 6 znaków", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password2.equals(password)) {
                    Toast.makeText(MainActivity.this, "hasło musi się powtarzać", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(MainActivity.this, "Formularz został poprawnie wysłany!", Toast.LENGTH_SHORT).show();
                buttonSubmit.setText("potwierdzone");


                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
            }
        });
    }
}