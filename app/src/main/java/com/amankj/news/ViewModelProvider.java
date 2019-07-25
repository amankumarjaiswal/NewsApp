package com.amankj.news;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.amankj.news.viewmodel.TopHeadlinesViewModel;

public class ViewModelProvider {
    private static final String TAG = ViewModelProvider.class.getSimpleName();

    public static TopHeadlinesViewModel getTopHeadlinesViewModel(FragmentActivity activity) {
        Log.d(TAG, "getTopHeadlinesViewModel");

        return ViewModelProviders.of(activity).get(TopHeadlinesViewModel.class);
    }

}
