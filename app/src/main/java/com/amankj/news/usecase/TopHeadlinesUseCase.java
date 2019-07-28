package com.amankj.news.usecase;

import android.util.Log;
import com.amankj.news.data.INewsDataSource;
import io.reactivex.Flowable;

public class TopHeadlinesUseCase {
    private static final String TAG = TopHeadlinesUseCase.class.getSimpleName();

    private INewsDataSource newsDataSource;

    public TopHeadlinesUseCase(INewsDataSource newsDataSource) {
        this.newsDataSource = newsDataSource;
    }

    public Flowable<Object> getTopHeadlines() {
        Log.d(TAG, "getTopHeadlines");

        return newsDataSource.getTopHeadlinesRemote();
    }
}
