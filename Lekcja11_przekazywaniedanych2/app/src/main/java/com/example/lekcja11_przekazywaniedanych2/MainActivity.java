package com.example.lekcja11_przekazywaniedanych2;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM1 = "com.example.lekcja11_przekazywaniedanych2.number1";
    public static final String EXTRA_NUM2 = "com.example.lekcja11_przekazywaniedanych2.number2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Button calcButton = findViewById(R.id.calcbtn);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(num1.getText().toString());
                int b = Integer.parseInt(num2.getText().toString());

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_NUM1, a);
                intent.putExtra(EXTRA_NUM2, b);
                startActivity(intent);
            }
        });
    }
}