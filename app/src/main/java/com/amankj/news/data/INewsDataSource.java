package com.amankj.news.data;

import io.reactivex.Flowable;

public interface INewsDataSource {

    Flowable<Object> getTopHeadlinesRemote();
}
