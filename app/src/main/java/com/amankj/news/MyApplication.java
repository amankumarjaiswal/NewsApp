package com.amankj.news;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;

public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
        RxJavaPlugins.setErrorHandler(Functions.<Throwable>emptyConsumer());
    }

    public static Context getAppContext() {
        Log.d(TAG, "getAppContext");

        return applicationContext;
    }
}
