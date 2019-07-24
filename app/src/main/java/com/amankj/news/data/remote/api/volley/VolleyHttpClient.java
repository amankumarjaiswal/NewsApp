package com.amankj.news.data.remote.api.volley;

import android.content.Context;
import android.util.Log;
import com.amankj.news.data.remote.api.IHttpClient;
import com.amankj.news.data.remote.api.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyHttpClient implements IHttpClient {
    private static final String TAG = VolleyHttpClient.class.getSimpleName();

    private RequestQueue requestQueue;
    private Request.RequestCallback requestCallback;

    public VolleyHttpClient(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public boolean issueRequest(Request request) {
        Log.d(TAG, "issueRequest");

        requestCallback = request.getRequestCallback();

        StringRequest stringRequest = new StringRequest(request.getMethod(), request.getUrl(), responseListener, errorListener);
        requestQueue.add(stringRequest);

        return true;
    }

    private Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onResponse");
            Log.i(TAG, "Response : " + response);

            requestCallback.onSuccess(response);
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "onErrorResponse");

            requestCallback.onError();
        }
    };
}
