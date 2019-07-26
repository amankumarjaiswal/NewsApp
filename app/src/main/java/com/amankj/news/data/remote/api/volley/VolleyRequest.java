package com.amankj.news.data.remote.api.volley;

import android.util.Log;
import androidx.annotation.Nullable;
import com.android.volley.*;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import java.io.UnsupportedEncodingException;

public class VolleyRequest extends StringRequest {
    private static final String TAG = VolleyRequest.class.getSimpleName();

    VolleyRequest(int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        Log.d(TAG, "parseNetworkResponse");

        try {
            Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
            if (cacheEntry == null) {
                cacheEntry = new Cache.Entry();
            }
            final long cacheHitButRefreshed = 3 * 60 * 1000; // in 3 minutes cache will be hit, but also refreshed on background
            final long cacheExpired = 24 * 60 * 60 * 1000; // in 24 hours this cache entry expires completely
            long now = System.currentTimeMillis();
            final long softExpire = now + cacheHitButRefreshed;
            final long ttl = now + cacheExpired;
            cacheEntry.data = response.data;
            cacheEntry.softTtl = softExpire;
            cacheEntry.ttl = ttl;
            String headerValue;
            headerValue = response.headers.get("Date");
            if (headerValue != null) {
                cacheEntry.serverDate = HttpHeaderParser.parseDateAsEpoch(headerValue);
            }
            headerValue = response.headers.get("Last-Modified");
            if (headerValue != null) {
                cacheEntry.lastModified = HttpHeaderParser.parseDateAsEpoch(headerValue);
            }
            cacheEntry.responseHeaders = response.headers;
            final String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(jsonString, cacheEntry);
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        Log.d(TAG, "deliverResponse");
        super.deliverResponse(response);
    }

    @Override
    public void deliverError(VolleyError error) {
        Log.d(TAG, "deliverError");
        super.deliverError(error);
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        Log.e(TAG, "parseNetworkError");
        return super.parseNetworkError(volleyError);
    }

}
