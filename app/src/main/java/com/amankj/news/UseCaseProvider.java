package com.amankj.news;

import android.content.Context;
import android.util.Log;
import com.amankj.news.usecase.TopHeadlinesUseCase;

public class UseCaseProvider {
    private static final String TAG = UseCaseProvider.class.getSimpleName();

    public static TopHeadlinesUseCase getTopHeadlinesUseCase(Context context) {
        Log.d(TAG, "getTopHeadlinesUseCase");

        return new TopHeadlinesUseCase(DataSourceProvider.getNewsDataSource(context));
    }
}
