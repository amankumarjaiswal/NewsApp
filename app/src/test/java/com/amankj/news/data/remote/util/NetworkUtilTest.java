package com.amankj.news.data.remote.util;

import com.amankj.news.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkUtilTest extends BaseTest {

    /*@Test
    public void getNewsApiUriBuilder() {
        Uri.Builder builder = PowerMockito.mock(Uri.Builder.class);
        Uri.Builder builder1 = NetworkUtil.getNewsApiUriBuilder();
        assertEquals(builder1, builder);
    }*/

    @Test
    public void getNewsApiKey() {
        assertEquals(NetworkUtil.getNewsApiKey(), "85244d96cb80440aa8c82f0c538a4273");
    }
}