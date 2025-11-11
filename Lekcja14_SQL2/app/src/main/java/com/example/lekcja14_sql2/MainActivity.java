package com.example.lekcja14_sql2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Database dbHelper;
    private EditText nameInput, phoneInput;
    private Button saveButton;
    private TextView contactsDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new Database(this);

        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);
        saveButton = findViewById(R.id.saveButton);
        contactsDisplay = findViewById(R.id.contactsDisplay);

        saveButton.setOnClickListener(v -> addContact());


        loadContacts();
    }

    private void addContact() {
        String name = nameInput.getText().toString().trim();
        String phone = phoneInput.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty()) return;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_NAME, name);
        values.put(Database.COLUMN_PHONE, phone);
        db.insert(Database.TABLE_CONTACTS, null, values);
        db.close();

        nameInput.setText("");
        phoneInput.setText("");
        loadContacts();
    }

    private void loadContacts() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                Database.COLUMN_ID,
                Database.COLUMN_NAME,
                Database.COLUMN_PHONE
        };

        Cursor cursor = db.query(
                Database.TABLE_CONTACTS,
                projection,
                null, null, null, null, null
        );

        StringBuilder contacts = new StringBuilder("Lista kontaktów:\n\n");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(Database.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Database.COLUMN_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(Database.COLUMN_PHONE));

            contacts.append(id).append(". ").append(name)
                    .append(" - ").append(phone).append("\n");
        }

        cursor.close();
        db.close();
        contactsDisplay.setText(contacts.toString());
    }
}
