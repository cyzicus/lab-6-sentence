package com.cyzicus.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${nounService}", fallback = NounFallback.class)
public interface NounClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getNoun();
}
