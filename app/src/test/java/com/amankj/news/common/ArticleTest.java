package com.amankj.news.common;

import com.amankj.news.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTest extends BaseTest {

    private Article article;

    @Before
    public void setUp() {
        super.setUp();

        article = new Article();
        article.setSource(article.new Source());
        article.getSource().setId("sourceId");
        article.getSource().setName("sourceName");
        article.setAuthor("author");
        article.setTitle("title");
        article.setDescription("description");
        article.setUrl("url");
        article.setUrlToImage("urlToImage");
        article.setPublishedAt("publishAt");
        article.setContent("content");
    }

    @Test
    public void getSourceTest() {
        assertEquals(article.getSource().getId(), "sourceId");
        assertEquals(article.getSource().getName(), "sourceName");
    }

    @Test
    public void setSourceTest() {
        article.getSource().setId("newId");
        article.getSource().setName("newName");

        assertEquals(article.getSource().getId(), "newId");
        assertEquals(article.getSource().getName(), "newName");
    }

    @Test
    public void getAuthorTest() {
        assertEquals(article.getAuthor(), "author");
    }

    @Test
    public void setAuthorTest() {
        article.setAuthor("newAuthor");
        assertEquals(article.getAuthor(), "newAuthor");
    }

    @Test
    public void getTitleTest() {
        assertEquals(article.getTitle(), "title");
    }

    @Test
    public void setTitleTest() {
        article.setTitle("newTitle");
        assertEquals(article.getTitle(), "newTitle");
    }

    @Test
    public void getDescriptionTest() {
        assertEquals(article.getDescription(), "description");
    }

    @Test
    public void setDescriptionTest() {
        article.setDescription("newDescription");
        assertEquals(article.getDescription(), "newDescription");
    }

    @Test
    public void getUrlTest() {
        assertEquals(article.getUrl(), "url");
    }

    @Test
    public void setUrlTest() {
        article.setUrl("newUrl");
        assertEquals(article.getUrl(), "newUrl");
    }

    @Test
    public void getUrlToImageTest() {
        assertEquals(article.getUrlToImage(), "urlToImage");
    }

    @Test
    public void setUrlToImageTest() {
        article.setUrlToImage("newUrlToImage");
        assertEquals(article.getUrlToImage(), "newUrlToImage");
    }

    @Test
    public void getPublishAtTest() {
        assertEquals(article.getPublishedAt(), "publishAt");
    }

    @Test
    public void setPublishAtTest() {
        article.setPublishedAt("newPublishAt");
        assertEquals(article.getPublishedAt(), "newPublishAt");
    }

    @Test
    public void getContentTest() {
        assertEquals(article.getContent(), "content");
    }

    @Test
    public void setContentTest() {
        article.setContent("newContent");
        assertEquals(article.getContent(), "newContent");
    }
}
