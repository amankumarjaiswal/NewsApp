package com.amankj.news.data.remote;

import io.reactivex.Single;

public interface ITopHeadlinesRemoteSource {

    Single<Object> getTopHeadlines();
}
