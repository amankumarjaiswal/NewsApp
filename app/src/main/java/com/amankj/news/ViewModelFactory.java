package com.amankj.news;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.util.Log;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static final String TAG = ViewModelFactory.class.getSimpleName();

    private static ViewModelFactory viewModelFactory;

    private ViewModelFactory() {
    }

    public static synchronized ViewModelFactory getInstance() {
        Log.d(TAG, "getInstance");

        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactory();
        }

        return viewModelFactory;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass, Activity activity) {
        return super.create(modelClass);
    }
}
