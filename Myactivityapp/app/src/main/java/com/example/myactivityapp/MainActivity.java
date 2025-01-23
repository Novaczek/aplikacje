package com.example.myactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    private TextView name2,email2,number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);

        name2=findViewById(R.id.name2);
        email2=findViewById(R.id.email2);
        number2=findViewById(R.id.number2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("message","Witaj w Secondactivity");
                startActivity(intent);
            }
        });

        String name_message=getIntent().getStringExtra("name");
        String email_message=getIntent().getStringExtra("email");
        String number_message=getIntent().getStringExtra("number");

        if(name2==null && email2==null && number2==null){
            name2.setText("Imie: "+"");
            email2.setText("adres email: "+"");
            number2.setText("numer telefonu: "+"");
        }else{
            name2.setText("Imie: "+name_message);
            email2.setText("adres email: "+email_message);
            number2.setText("numer telefonu: "+number_message);
        }
    }
}