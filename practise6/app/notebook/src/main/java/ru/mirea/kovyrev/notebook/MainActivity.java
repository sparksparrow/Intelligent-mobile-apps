package ru.mirea.kovyrev.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextContent;
    private SharedPreferences preferences1;
    private SharedPreferences preferences2;
    final String SAVED_TEXT = "saved_text";
    private String fileName;
    private String content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextContent = findViewById(R.id.editTextContent);
        preferences1 = getPreferences(MODE_PRIVATE);
        preferences2 = getPreferences(MODE_PRIVATE);
    }

    public void onSaveText(View view) {
        fileName = editTextName.getText().toString() + ".txt";
        content = editTextContent.getText().toString();
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SharedPreferences.Editor editor1 = preferences1.edit();
        SharedPreferences.Editor editor2 = preferences2.edit();
        editor1.putString("FileName", editTextName.getText().toString());
        editor2.putString("Content", editTextContent.getText().toString());
        editor1.apply();
        editor2.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void onLoadText(View view) {
        String fileName = preferences1.getString("FileName", "");
        editTextName.setText(fileName);
        String content = preferences2.getString("Content", "");
        editTextContent.setText(content);
    }
}