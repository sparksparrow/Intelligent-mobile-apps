package com.mirea.Kovyrev.practise1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_main_task7 extends AppCompatActivity {
    private TextView tvOut;
    private Button buttonOk;
    private Button buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_task7);
        tvOut = (TextView) findViewById(R.id.tvOut);
        buttonOk = (Button) findViewById((R.id.btnOk));
        buttonCancel = (Button) findViewById((R.id.btnCancel));

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Нажата кнопка ОК");
            }
        };

        buttonOk.setOnClickListener(oclBtnOk);
    }

    public void onMyButtonClick(View view)
    {
        Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_SHORT).show();
        tvOut.setText("Нажата кнопка Cancel");
    }
}
