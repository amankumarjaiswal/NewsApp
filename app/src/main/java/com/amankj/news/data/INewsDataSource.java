package com.amankj.news.data;

import io.reactivex.Single;

public interface INewsDataSource {

    Single<Object> getTopHeadlinesRemote();
}
