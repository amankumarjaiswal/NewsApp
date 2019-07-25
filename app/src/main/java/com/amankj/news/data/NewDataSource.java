package com.amankj.news.data;

import android.util.Log;
import com.amankj.news.data.remote.ITopHeadlinesRemoteSource;
import io.reactivex.Single;

public class NewDataSource implements INewsDataSource {
    private static final String TAG = NewDataSource.class.getSimpleName();

    private ITopHeadlinesRemoteSource topHeadlinesRemoteSource;

    public NewDataSource(ITopHeadlinesRemoteSource topHeadlinesRemoteSource) {
        this.topHeadlinesRemoteSource = topHeadlinesRemoteSource;
    }

    @Override
    public Single<Object> getTopHeadlinesRemote() {
        Log.d(TAG, "getTopHeadlinesRemote");

        return topHeadlinesRemoteSource.getTopHeadlines();
    }
}
