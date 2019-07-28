package com.amankj.news.data;

import com.amankj.news.BaseTest;
import com.amankj.news.data.remote.ITopHeadlinesRemoteSource;
import io.reactivex.Flowable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.reactivestreams.Subscriber;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

public class NewsDataSourceTest extends BaseTest {

    @Mock
    private ITopHeadlinesRemoteSource topHeadlinesRemoteSource;

    private Flowable<Object> objectFlowable = new Flowable<Object>() {
        @Override
        protected void subscribeActual(Subscriber<? super Object> s) {
        }
    };

    @Before
    public void setUp() {
        super.setUp();
        when(topHeadlinesRemoteSource.getTopHeadlines()).thenReturn(objectFlowable);
    }

    @Test
    public void getTopHeadlinesRemote() {
        NewsDataSource newsDataSource = new NewsDataSource(topHeadlinesRemoteSource);
        assertEquals(newsDataSource.getTopHeadlinesRemote(), objectFlowable);
    }
}