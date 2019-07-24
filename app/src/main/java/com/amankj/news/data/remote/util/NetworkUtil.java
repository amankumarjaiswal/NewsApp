package com.amankj.news.data.remote.util;

import android.net.Uri;
import android.util.Log;
import com.amankj.news.BuildConfig;

public class NetworkUtil {
    private static final String TAG = NetworkUtil.class.getSimpleName();

    private static final String URI_SCHEME = "https";
    private static final String NEWS_API_AUTHORITY = "newsapi.org";
    private static final String NEW_API_V2_PATH = "v2";

    public static Uri.Builder getNewsApiUriBuilder() {
        Log.d(TAG, "getNewsApiUriBuilder");

        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme(URI_SCHEME);
        uriBuilder.authority(NEWS_API_AUTHORITY);
        uriBuilder.appendPath(NEW_API_V2_PATH);

        return uriBuilder;
    }

    public static String getNewsApiKey() {
        Log.d(TAG, "getNewsApiKey");

        return BuildConfig.NEWS_API_KEY;
    }
}
