package com.cyzicus.client;

import org.springframework.stereotype.Component;

@Component
public class ArticleFallback implements ArticleClient {
    @Override
    public String getArticle() {
        return "the";
    }
}
