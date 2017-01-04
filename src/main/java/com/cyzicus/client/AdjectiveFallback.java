package com.cyzicus.client;

import org.springframework.stereotype.Component;

@Component
public class AdjectiveFallback implements AdjectiveClient {
    @Override
    public String getAdjective() {
        return "difficult";
    }
}
