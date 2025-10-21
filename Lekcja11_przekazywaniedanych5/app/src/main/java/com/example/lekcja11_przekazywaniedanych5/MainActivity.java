package com.example.lekcja11_przekazywaniedanych5;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_PREMIUM = "com.example.lekcja11_przekazywaniedanych5.PREMIUM";

    private Switch premiumSwitch;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        premiumSwitch = findViewById(R.id.premiumSwitch);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isPremiumEnabled = premiumSwitch.isChecked();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_PREMIUM, isPremiumEnabled);
                startActivity(intent);
            }
        });
    }
}