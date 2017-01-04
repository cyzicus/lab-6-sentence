package com.cyzicus.client;

import org.springframework.stereotype.Component;

@Component
public class VerbFallback implements VerbClient{

    @Override
    public String getVerb() {
        return "walked";
    }
}
