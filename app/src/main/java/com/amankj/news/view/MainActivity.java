package com.amankj.news.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.amankj.news.R;
import com.amankj.news.UseCaseProvider;
import com.amankj.news.usecase.TopHeadlinesUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopHeadlinesUseCase topHeadlinesUseCase = UseCaseProvider.getTopHeadlinesUseCase(MainActivity.this.getApplicationContext());
                topHeadlinesUseCase.getTopHeadlines();
            }
        });
    }
}
