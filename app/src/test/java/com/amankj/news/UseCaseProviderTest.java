package com.amankj.news;

import com.amankj.news.data.remote.api.volley.VolleyHttpClient;
import com.amankj.news.usecase.TopHeadlinesUseCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest({DataSourceProvider.class})
public class UseCaseProviderTest extends BaseTest {

    @Mock
    VolleyHttpClient volleyHttpClient;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        try {
            whenNew(VolleyHttpClient.class).withNoArguments().thenReturn(volleyHttpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getTopHeadlinesUseCase() {
        TopHeadlinesUseCase topHeadlinesUseCase = UseCaseProvider.getTopHeadlinesUseCase();

        assertThat(topHeadlinesUseCase, instanceOf(TopHeadlinesUseCase.class));
    }
}