package com.amankj.news.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.amankj.news.R;
import com.amankj.news.ViewModelProvider;
import com.amankj.news.viewmodel.TopHeadlinesViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick");
                getTopHeadlines();
            }
        });
    }

    private void getTopHeadlines() {
        Log.d(TAG, "getTopHeadlines");

        TopHeadlinesViewModel topHeadlinesViewModel = ViewModelProvider.getTopHeadlinesViewModel(this);
        topHeadlinesViewModel.getTopHeadlines(this);
        topHeadlinesViewModel.getArticleListObservable().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                Log.d(TAG, "onChanged");

                textView.setText(o.toString());
            }
        });
    }
}
