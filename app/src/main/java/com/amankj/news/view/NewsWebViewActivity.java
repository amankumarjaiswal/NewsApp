package com.amankj.news.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.amankj.news.R;

public class NewsWebViewActivity extends AppCompatActivity {
    private static final String TAG = NewsWebViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_news_web_view);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        TextView brokenText = findViewById(R.id.link_broken_text);
        WebView webView = findViewById(R.id.web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if (!isNetworkConnected()) {
            Log.d(TAG, "network not connnected");
            webView.setVisibility(View.GONE);
            brokenText.setVisibility(View.VISIBLE);
            brokenText.setText("You are offline!");
        } else if (url == null) {
            Log.d(TAG, "url is null");
            webView.setVisibility(View.GONE);
            brokenText.setText(View.VISIBLE);
        } else {
            Log.d(TAG, "url: " + url);
            brokenText.setVisibility(View.GONE);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl(url);
        }
    }

    private boolean isNetworkConnected() {
        Log.d(TAG, "isNetworkConnected");

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
