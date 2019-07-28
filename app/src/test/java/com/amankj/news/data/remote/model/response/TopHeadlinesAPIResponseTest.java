package com.amankj.news.data.remote.model.response;

import com.amankj.news.BaseTest;
import com.amankj.news.common.Article;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TopHeadlinesAPIResponseTest extends BaseTest {

    private TopHeadlinesAPIResponse topHeadlinesAPIResponse;
    private ArrayList<Article> articles;

    @Before
    public void setUp() {
        super.setUp();

        articles = new ArrayList<>();

        topHeadlinesAPIResponse = new TopHeadlinesAPIResponse();
        topHeadlinesAPIResponse.setStatus("status");
        topHeadlinesAPIResponse.setTotalResults(10);
        topHeadlinesAPIResponse.setArticles(articles);
    }

    @Test
    public void getStatus() {
        assertEquals(topHeadlinesAPIResponse.getStatus(), "status");
    }

    @Test
    public void setStatus() {
        topHeadlinesAPIResponse.setStatus("newStatus");
        assertEquals(topHeadlinesAPIResponse.getStatus(), "newStatus");
    }

    @Test
    public void getTotalResults() {
        assertEquals(topHeadlinesAPIResponse.getTotalResults(), 10);
    }

    @Test
    public void setTotalResults() {
        topHeadlinesAPIResponse.setTotalResults(15);
        assertEquals(topHeadlinesAPIResponse.getTotalResults(), 15);
    }

    @Test
    public void getArticles() {
        assertEquals(topHeadlinesAPIResponse.getArticles(), articles);
    }

    @Test
    public void setArticles() {
        ArrayList<Article> articles1 = new ArrayList<>();
        articles1.add(new Article());
        topHeadlinesAPIResponse.setArticles(articles1);
        assertEquals(topHeadlinesAPIResponse.getArticles(), articles1);
    }
}