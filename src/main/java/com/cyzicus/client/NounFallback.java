package com.cyzicus.client;

import org.springframework.stereotype.Component;

@Component
public class NounFallback implements NounClient{
    @Override
    public String getNoun() {
        return "race";
    }
}
