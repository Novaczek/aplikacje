package com.example.osobiste_powitanie;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID="ID";

    private EditText yourimie;
    private Button btn_przywitaj;
    private String imie_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        yourimie=findViewById(R.id.yourimie);
        btn_przywitaj=findViewById(R.id.button);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        AlertDialog.Builder builder2=new AlertDialog.Builder(this);
        CreatNotificationChannel();
        btn_przywitaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imie_value=yourimie.getText().toString().trim();

                if(imie_value.isEmpty()){

                    builder.setTitle("Błąd");
                    builder.setMessage("Proszę wpisać swoje imię!");

                    builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this,"OK!",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();

                }else{

                    builder2.setTitle("Potwierdzenie");
                    builder2.setMessage("Cześć "+imie_value+" ! Czy chcesz otrzymać powiadomienia powitalne?");
                    builder2.setPositiveButton("Tak, poproszę",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Notification();
                            Toast.makeText(MainActivity.this,"Powiadomienie zostało wysłane!",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder2.setNegativeButton("Nie, dziękuję",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"Rozumiem.Nie wysyłam Powiadomienia!",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder2.show();
                }
            }
        });

    }
    private void CreatNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "kanal_powiadomien!", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("opis_kanalu");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void Notification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("Witaj!").setStyle(new NotificationCompat.BigTextStyle().bigText("Miło cię widzieć , " + imie_value + " !")).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notificationM = NotificationManagerCompat.from(this);
            notificationM.notify(1, builder.build());
        }
    }
}