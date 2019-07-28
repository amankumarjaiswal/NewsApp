package com.amankj.news.data.remote;

import io.reactivex.Flowable;

public interface ITopHeadlinesRemoteSource {

    Flowable<Object> getTopHeadlines();
}
