package com.amankj.news;

import android.util.Log;
import com.amankj.news.data.INewsDataSource;
import com.amankj.news.data.NewsDataSource;
import com.amankj.news.data.remote.TopHeadlinesRemoteSource;
import com.amankj.news.data.remote.api.volley.VolleyHttpClient;

public class DataSourceProvider {
    private static final String TAG = DataSourceProvider.class.getSimpleName();

    public static INewsDataSource getNewsDataSource() {
        Log.d(TAG, "getNewsDataSource");

        return new NewsDataSource(new TopHeadlinesRemoteSource(new VolleyHttpClient()));
    }
}
