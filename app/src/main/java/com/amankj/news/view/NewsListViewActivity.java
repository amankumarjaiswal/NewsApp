package com.amankj.news.view;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amankj.news.R;
import com.amankj.news.ViewModelProvider;
import com.amankj.news.common.Article;
import com.amankj.news.viewmodel.TopHeadlinesViewModel;

import java.util.ArrayList;

public class NewsListViewActivity extends AppCompatActivity {
    private static final String TAG = NewsListViewActivity.class.getSimpleName();

    private ArrayList<Article> articleArrayList = new ArrayList<>();
    private NewsListAdapter newsListAdapter;

    private NewsListViewActivity newsListViewActivity;
    private RecyclerView newsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list_view);

        newsListViewActivity = NewsListViewActivity.this;

        newsListView = findViewById(R.id.news_list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        newsListView.setLayoutManager(linearLayoutManager);
        getTopHeadlines();
    }

    private void getTopHeadlines() {
        Log.d(TAG, "getTopHeadlines");

        TopHeadlinesViewModel topHeadlinesViewModel = ViewModelProvider.getTopHeadlinesViewModel(newsListViewActivity);
        topHeadlinesViewModel.getTopHeadlines(newsListViewActivity);
        topHeadlinesViewModel.getArticleListObservable().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object object) {
                Log.d(TAG, "onChanged");

                articleArrayList = (ArrayList<Article>) object;
                newsListAdapter = new NewsListAdapter(newsListViewActivity, articleArrayList);
                newsListView.setAdapter(newsListAdapter);
                Log.d(TAG, "size: " + articleArrayList.size());
                newsListAdapter.notifyDataSetChanged();
            }
        });
    }
}
