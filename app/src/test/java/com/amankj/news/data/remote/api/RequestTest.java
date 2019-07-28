package com.amankj.news.data.remote.api;

import com.amankj.news.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class RequestTest extends BaseTest {

    private Request request;

    @Mock
    Request.RequestCallback requestCallback;

    @Before
    public void setUp() {
        super.setUp();

        request = new Request("url", Request.Method.GET, requestCallback);
    }

    @Test
    public void getUrl() {
        assertEquals(request.getUrl(), "url");
    }

    @Test
    public void getMethod() {
        assertEquals(request.getMethod(), Request.Method.GET);
    }

    @Test
    public void getRequestCallback() {
        assertEquals(request.getRequestCallback(), requestCallback);
    }
}