package com.example.myactivityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
    private TextView text;
    private Button btn2;

    private EditText name,email,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        btn2=findViewById(R.id.button2);
        text=findViewById(R.id.textView);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);

        String message=getIntent().getStringExtra("message");
        text.setText(message);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_input=name.getText().toString().trim();
                String email_input=email.getText().toString().trim();
                String number_input=number.getText().toString().trim();

                if(name_input.isEmpty()){
                    Toast.makeText(SecondActivity.this,"pole Imie nie moze byc puste!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(email_input.isEmpty()){
                    Toast.makeText(SecondActivity.this,"pole adres email nie moze byc puste!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(number_input.isEmpty()){
                    Toast.makeText(SecondActivity.this,"pole numer telefonu nie moze byc puste!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(number_input.length()!=9){
                    Toast.makeText(SecondActivity.this,"pole numer telefonu musi zawierac 9 cyfr!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!email_input.contains("@")){
                    Toast.makeText(SecondActivity.this,"pole adres email musi zawierac @!!!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(!name_input.isEmpty() && !email_input.isEmpty() && !number_input.isEmpty() && email_input.contains("@") && number_input.length()==9){
                    Intent intent2=new Intent(SecondActivity.this, MainActivity.class);
                    intent2.putExtra("name",name_input);
                    intent2.putExtra("email",email_input);
                    intent2.putExtra("number",number_input);
                    startActivity(intent2);
                }
            }
        });
    }
}