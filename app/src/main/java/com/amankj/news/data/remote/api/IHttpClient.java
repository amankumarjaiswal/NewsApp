package com.amankj.news.data.remote.api;

public interface IHttpClient {

    int API_BASE = 1000;

    boolean issueRequest(Request request);
}
