package com.example.lekcja10_navigation2_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Zad 2
        Button btn_call=findViewById(R.id.call);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:123456789"));
                startActivity(intent);
            }
        });

        //Zad 3
        Button btn_show=findViewById(R.id.showmap);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:52.2318,21.0060"));
                startActivity(intent);
            }
        });

        //Zad 4
        Button btn_send=findViewById(R.id.send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:test@example.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Wiadomość z mojej aplikacji");
                startActivity(intent);
            }
        });

        //Zad 5
        Button btn_open=findViewById(R.id.opengalery);

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(""), "image/*");
                startActivity(intent);
            }
        });
    }
}

