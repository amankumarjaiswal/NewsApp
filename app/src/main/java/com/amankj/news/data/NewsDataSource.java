package com.amankj.news.data;

import android.util.Log;
import com.amankj.news.data.remote.ITopHeadlinesRemoteSource;
import io.reactivex.Flowable;

public class NewsDataSource implements INewsDataSource {
    private static final String TAG = NewsDataSource.class.getSimpleName();

    private ITopHeadlinesRemoteSource topHeadlinesRemoteSource;

    public NewsDataSource(ITopHeadlinesRemoteSource topHeadlinesRemoteSource) {
        this.topHeadlinesRemoteSource = topHeadlinesRemoteSource;
    }

    @Override
    public Flowable<Object> getTopHeadlinesRemote() {
        Log.d(TAG, "getTopHeadlinesRemote");

        return topHeadlinesRemoteSource.getTopHeadlines();
    }
}
