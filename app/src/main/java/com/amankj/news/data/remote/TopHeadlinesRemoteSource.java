package com.amankj.news.data.remote;

import android.net.Uri;
import android.util.Log;
import com.amankj.news.data.remote.api.IHttpClient;
import com.amankj.news.data.remote.api.Request;
import com.amankj.news.data.remote.model.response.TopHeadlinesAPIResponse;
import com.amankj.news.data.remote.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class TopHeadlinesRemoteSource implements ITopHeadlinesRemoteSource {
    private static final String TAG = TopHeadlinesRemoteSource.class.getSimpleName();

    private static final String PATH_TOP_HEADLINES = "top-headlines";
    private static final String KEY_COUNTRY = "country";
    private static final String KEY_API_KEY = "apiKey";

    private IHttpClient httpClient;

    public TopHeadlinesRemoteSource(IHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Single<Object> getTopHeadlines() {
        Log.d(TAG, "getTopHeadlines");

        String apiKey = NetworkUtil.getNewsApiKey();
        Uri.Builder uriBuilder = NetworkUtil.getNewsApiUriBuilder();
        uriBuilder.appendPath(PATH_TOP_HEADLINES);
        uriBuilder.appendQueryParameter(KEY_COUNTRY, "in");
        uriBuilder.appendQueryParameter(KEY_API_KEY, apiKey);

        final String url = uriBuilder.build().toString();
        Log.i(TAG, "url : " + url);

        return Single.create(new SingleOnSubscribe<Object>() {
            @Override
            public void subscribe(final SingleEmitter<Object> emitter) throws Exception {
                Request request = new Request(url, Request.Method.GET, new Request.RequestCallback() {
                    @Override
                    public void onSuccess(Object object) {
                        Log.d(TAG, "onSuccess");

                        TopHeadlinesAPIResponse topHeadlinesAPIResponse = parseResponse(object);
                        if (topHeadlinesAPIResponse == null) {
                            emitter.onError(new Throwable("Response is null"));
                        } else if ("error".equals(topHeadlinesAPIResponse.getStatus())) {
                            emitter.onError(new Throwable("Error Response"));
                        } else {
                            emitter.onSuccess(topHeadlinesAPIResponse.getArticles());
                        }
                    }

                    @Override
                    public void onError() {
                        Log.e(TAG, "onError");
                        emitter.onError(new Throwable());
                    }
                });
                httpClient.issueRequest(request);
            }
        });
    }

    private TopHeadlinesAPIResponse parseResponse(Object response) {
        Log.d(TAG, "parseResponse");

        TopHeadlinesAPIResponse topHeadlinesAPIResponse = null;
        Gson gson = new Gson();
        try {
            topHeadlinesAPIResponse = gson.fromJson(response.toString(), TopHeadlinesAPIResponse.class);
        } catch (JsonParseException e) {
            Log.e(TAG, "parseResponse: " + e.getMessage());
        }

        return topHeadlinesAPIResponse;
    }

}
