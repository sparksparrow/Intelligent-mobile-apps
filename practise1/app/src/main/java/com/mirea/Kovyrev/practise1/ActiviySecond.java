package com.mirea.Kovyrev.practise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ActiviySecond extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText myEditText = (EditText) findViewById(R.id.editText);
        myEditText.setText("New text in MIREA");
        Button button = findViewById(R.id.button8);
        button.setText("MireaButton");
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(true);
    }
}
