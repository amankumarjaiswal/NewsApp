package com.amankj.news.data.remote;

import android.net.Uri;
import android.util.Log;
import com.amankj.news.data.remote.api.IHttpClient;
import com.amankj.news.data.remote.api.Request;
import com.amankj.news.data.remote.util.NetworkUtil;

public class TopHeadlinesRemoteSource implements ITopHeadlinesRemoteSource, Request.RequestCallback {
    private static final String TAG = TopHeadlinesRemoteSource.class.getSimpleName();

    private static final String PATH_TOP_HEADLINES = "top-headlines";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_API_KEY = "apiKey";

    private IHttpClient httpClient;

    public TopHeadlinesRemoteSource(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void getTopHeadlines() {
        Log.d(TAG, "getTopHeadlines");

        String apiKey = NetworkUtil.getNewsApiKey();
        Uri.Builder uriBuilder = NetworkUtil.getNewsApiUriBuilder();
        uriBuilder.appendPath(PATH_TOP_HEADLINES);
        uriBuilder.appendQueryParameter(KEY_COUNTRY, "in");
        uriBuilder.appendQueryParameter(KEY_API_KEY, apiKey);

        String url = uriBuilder.build().toString();
        Log.i(TAG, "url : " + url);

        Request request = new Request(url, Request.Method.GET, this);
        httpClient.issueRequest(request);
    }

    @Override
    public void onSuccess(Object object) {
        Log.d(TAG, "onSuccess");

    }

    @Override
    public void onError() {
        Log.d(TAG, "onError");
    }
}
