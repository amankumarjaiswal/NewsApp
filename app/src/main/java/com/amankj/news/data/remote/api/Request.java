package com.amankj.news.data.remote.api;

public class Request {
    private String url;
    private int method;
    private RequestCallback requestCallback;

    public interface Method {
        int GET = 0;
    }

    public interface RequestCallback {
        void onSuccess(Object object);

        void onError();
    }

    public Request(String url, int method, RequestCallback requestCallback) {
        this.url = url;
        this.method = method;
        this.requestCallback = requestCallback;
    }

    public String getUrl() {
        return url;
    }

    public int getMethod() {
        return method;
    }

    public RequestCallback getRequestCallback() {
        return requestCallback;
    }
}
