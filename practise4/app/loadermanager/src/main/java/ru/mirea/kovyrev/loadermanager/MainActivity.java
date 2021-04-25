package ru.mirea.kovyrev.loadermanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String> {
    public final String TAG = this.getClass().getSimpleName();
    private TextView mResultTextView;
    public static final int LOADER_ID = 1;
    private Loader<String> mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.resultTxt);

        Bundle bundle = new Bundle();
        bundle.putString(MyLoader.ARG_WORD, "test");
        mLoader = getSupportLoaderManager().initLoader(LOADER_ID, bundle, this);
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Loader<String> mLoader = null;
        if (id == LOADER_ID) {
            mLoader = new MyLoader(this, args);
            Log.d(TAG, "onCreateLoader");
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        Log.d(TAG, "onLoadFinished");
        mResultTextView.setText(data);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    public void onClick(View view) {
        Log.d(TAG, "startLoad");
        mLoader.onContentChanged();
    }
}