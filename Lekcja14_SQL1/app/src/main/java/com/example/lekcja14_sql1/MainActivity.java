package com.example.lekcja14_sql1;


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
    private EditText titleInput, noteInput;
    private EditText deleteIdInput, updateIdInput, updateTextInput;
    private Button saveButton, deleteButton, updateButton;
    private TextView notesDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new Database(this);


        titleInput = findViewById(R.id.titleInput);
        noteInput = findViewById(R.id.noteInput);
        deleteIdInput = findViewById(R.id.deleteIdInput);
        updateIdInput = findViewById(R.id.updateIdInput);
        updateTextInput = findViewById(R.id.updateTextInput);

        saveButton = findViewById(R.id.saveButton);
        deleteButton = findViewById(R.id.deleteButton);
        updateButton = findViewById(R.id.updateButton);
        notesDisplay = findViewById(R.id.notesDisplay);


        saveButton.setOnClickListener(v -> addNote());
        deleteButton.setOnClickListener(v -> deleteNote());
        updateButton.setOnClickListener(v -> updateNote());

        loadNotes();
    }

    private void addNote() {
        String title = titleInput.getText().toString().trim();
        String note = noteInput.getText().toString().trim();
        if (title.isEmpty() || note.isEmpty()) return;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_TITLE, title);
        values.put(Database.COLUMN_NOTE, note);
        db.insert(Database.TABLE_NOTES, null, values);
        db.close();

        titleInput.setText("");
        noteInput.setText("");
        loadNotes();
    }

    private void deleteNote() {
        String idToDelete = deleteIdInput.getText().toString().trim();
        if (idToDelete.isEmpty()) return;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Database.TABLE_NOTES, Database.COLUMN_ID + " = ?", new String[]{idToDelete});
        db.close();

        deleteIdInput.setText("");
        loadNotes();
    }

    private void updateNote() {
        String idToUpdate = updateIdInput.getText().toString().trim();
        String newText = updateTextInput.getText().toString().trim();
        if (idToUpdate.isEmpty() || newText.isEmpty()) return;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_NOTE, newText);
        db.update(Database.TABLE_NOTES, values, Database.COLUMN_ID + " = ?", new String[]{idToUpdate});
        db.close();

        updateIdInput.setText("");
        updateTextInput.setText("");
        loadNotes();
    }

    private void loadNotes() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                Database.COLUMN_ID,
                Database.COLUMN_TITLE,
                Database.COLUMN_NOTE
        };
        Cursor cursor = db.query(Database.TABLE_NOTES, projection, null, null, null, null, null);

        StringBuilder notes = new StringBuilder();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(Database.COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(Database.COLUMN_TITLE));
            String note = cursor.getString(cursor.getColumnIndexOrThrow(Database.COLUMN_NOTE));
            notes.append(id).append(". [").append(title).append("] ").append(note).append("\n");
        }

        cursor.close();
        db.close();
        notesDisplay.setText(notes.toString());
    }
}
