package ru.mirea.kovyrev.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread {
    int age = 20;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.d("Возраст ",age + ", " + msg.getData().getString("KEY"));
            }
        };
        handler.sendEmptyMessageDelayed(0,21);
        Looper.loop();
    }
}
