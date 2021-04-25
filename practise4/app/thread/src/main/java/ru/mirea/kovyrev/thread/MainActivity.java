package ru.mirea.kovyrev.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    Integer result;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Runnable runnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                editText1 = findViewById(R.id.et1);
                String string1 = editText1.getText().toString();
                editText2 = findViewById(R.id.et2);
                String string2 = editText2.getText().toString();
                int number1 = Integer.parseInt(string1);
                int number2 = Integer.parseInt(string2);
                textView = findViewById(R.id.tv);
                if ((number1 >= 0) && (number2 > 0)) {
                    result = number1 / number2;
                    textView.setText("Среднее количество пар в день равно " + result);
                }
                else {
                    textView.setText("Неккоректные данные!");
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}