package com.amankj.news;

import android.content.Context;
import android.util.Log;
import com.amankj.news.data.INewsDataSource;
import com.amankj.news.data.NewDataSource;
import com.amankj.news.data.remote.TopHeadlinesRemoteSource;
import com.amankj.news.data.remote.api.volley.VolleyHttpClient;

public class DataSourceProvider {
    private static final String TAG = DataSourceProvider.class.getSimpleName();

    public static INewsDataSource getNewsDataSource(Context context) {
        Log.d(TAG, "getNewsDataSource");

        return new NewDataSource(new TopHeadlinesRemoteSource(new VolleyHttpClient(context)));
    }
}
