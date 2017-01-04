package com.cyzicus.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${articleService}", fallback = ArticleFallback.class)
public interface ArticleClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getArticle();
}
