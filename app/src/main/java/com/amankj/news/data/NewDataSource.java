package com.amankj.news.data;

import android.util.Log;
import com.amankj.news.data.remote.ITopHeadlinesRemoteSource;

public class NewDataSource implements INewsDataSource {
    private static final String TAG = NewDataSource.class.getSimpleName();

    private ITopHeadlinesRemoteSource topHeadlinesRemoteSource;

    public NewDataSource(ITopHeadlinesRemoteSource topHeadlinesRemoteSource) {
        this.topHeadlinesRemoteSource = topHeadlinesRemoteSource;
    }

    @Override
    public void getTopHeadlinesRemote() {
        Log.d(TAG, "getTopHeadlinesRemote");

        topHeadlinesRemoteSource.getTopHeadlines();
    }
}
