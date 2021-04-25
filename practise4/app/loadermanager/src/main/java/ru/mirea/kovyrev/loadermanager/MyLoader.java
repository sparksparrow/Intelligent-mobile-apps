package ru.mirea.kovyrev.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.loader.content.AsyncTaskLoader;

import java.util.Random;

public class MyLoader extends AsyncTaskLoader<String> {
    public final String TAG = getClass().getSimpleName();
    public static final String ARG_WORD = "word";
    public static final int RANDOM_STRING_LENGTH = 20;
    private String mWord;

    public MyLoader(Context context, Bundle args) {
        super(context);
        if (args != null)
            mWord = args.getString(ARG_WORD);
    }

    @Override
    public String loadInBackground() {
        if (mWord == null) {
            return null;
        }
        Log.d(TAG, "loadInBackground");
        return generateString(mWord);
    }

    @Override
    public void forceLoad() {
        Log.d(TAG, "forceLoad");
        super.forceLoad();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d(TAG, "onStartLoading");
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        Log.d(TAG, "onStopLoading");
    }

    @Override
    public void deliverResult(String data) {
        Log.d(TAG, "deliverResult");
        super.deliverResult(data);
    }

    private String generateString(String characters) {
        Random rand = new Random();
        char[] text = new char[RANDOM_STRING_LENGTH];
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        return new String(text);
    }
}