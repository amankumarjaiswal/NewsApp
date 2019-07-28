package com.amankj.news.usecase;

import com.amankj.news.BaseTest;
import com.amankj.news.data.INewsDataSource;
import io.reactivex.Flowable;
import org.junit.Test;
import org.mockito.Mock;
import org.reactivestreams.Subscriber;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

public class TopHeadlinesUseCaseTest extends BaseTest {

    @Mock
    private INewsDataSource newsDataSource;

    private Flowable<Object> objectFlowable = new Flowable<Object>() {
        @Override
        protected void subscribeActual(Subscriber<? super Object> s) {
        }
    };

    @Test
    public void getTopHeadlines() {
        when(newsDataSource.getTopHeadlinesRemote()).thenReturn(objectFlowable);

        TopHeadlinesUseCase topHeadlinesUseCase = new TopHeadlinesUseCase(newsDataSource);

        assertEquals(topHeadlinesUseCase.getTopHeadlines(), objectFlowable);
    }
}