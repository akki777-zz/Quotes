package com.akshay.retrogson;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.akshay.retrogson.utils.AppUtils;
import com.akshay.retrogson.utils.Logger;
import com.akshay.retrogson.utils.rx.RxApiUtil;

import java.util.Locale;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private CompositeDisposable lifecycle;
    private Api quotesApi;

    /** Views */
    private TextView tvQuote;
    private TextView tvAuthor;
    private ProgressDialog progress;
    private MenuItem menuItemShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        lifecycle = new CompositeDisposable();
        quotesApi = RetroApp.getInstance().component().getMockApi();

        initToolbar();
        initViews();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0.0f);
    }

    private void initViews() {
        tvQuote = (TextView) findViewById(R.id.tvQuote);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
    }

    private void fetchData() {
        progress = AppUtils.showProgressDialog(MainActivity.this, getString(R.string.finding_quotes));
        lifecycle.add(RxApiUtil.build(quotesApi.getQuotes()).subscribe(quotes -> {
            tvQuote.setText(quotes.quote);
            tvAuthor.setText(String.format(Locale.ENGLISH, "~ %s", quotes.author));
            progress.dismiss();
        }, throwable -> {
            Logger.log(TAG, throwable);
            progress.dismiss();
            RetroApp.getInstance().showToastWithInternetHandling(R.string.err_occurred);
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quotes, menu);
        menuItemShare = menu.findItem(R.id.itemShare);
        menuItemShare.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemNext:
                fetchData();
                if (RetroApp.getInstance().isInternetAvailable()) {
                    menuItemShare.setVisible(true);
                }
                break;
            case R.id.itemShare:
                AppUtils.shareQuote(MainActivity.this, tvQuote.getText().toString(), tvAuthor.getText().toString());
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycle.clear();
    }
}
