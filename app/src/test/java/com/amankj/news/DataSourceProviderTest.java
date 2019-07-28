package com.amankj.news;

import com.amankj.news.data.INewsDataSource;
import com.amankj.news.data.remote.api.volley.VolleyHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest({DataSourceProvider.class})
public class DataSourceProviderTest extends BaseTest {

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
    public void getNewsDataSource() {
        INewsDataSource newsDataSource = DataSourceProvider.getNewsDataSource();

        assertThat(newsDataSource, instanceOf(INewsDataSource.class));
    }
}