package com.amankj.news.viewmodel;

import com.amankj.news.BaseTest;
import com.amankj.news.UseCaseProvider;
import com.amankj.news.usecase.TopHeadlinesUseCase;
import io.reactivex.Flowable;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.reactivestreams.Subscriber;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({UseCaseProvider.class})
public class TopHeadlinesViewModelTest extends BaseTest {

    @Mock
    private TopHeadlinesUseCase topHeadlinesUseCase;

    private TopHeadlinesViewModel topHeadlinesViewModel;
    private Flowable<Object> objectFlowable = new Flowable<Object>() {
        @Override
        protected void subscribeActual(Subscriber<? super Object> s) {
        }
    };

    @Override
    @Before
    public void setUp() {
        super.setUp();

        PowerMockito.mockStatic(UseCaseProvider.class);
        when(UseCaseProvider.getTopHeadlinesUseCase()).thenReturn(topHeadlinesUseCase);
        when(topHeadlinesUseCase.getTopHeadlines()).thenReturn(objectFlowable);

        topHeadlinesViewModel = new TopHeadlinesViewModel();
    }

    @Test
    public void getArticleListObservable() {
        topHeadlinesViewModel.getTopHeadlines();

        verify(topHeadlinesUseCase, times(1)).getTopHeadlines();
    }
}