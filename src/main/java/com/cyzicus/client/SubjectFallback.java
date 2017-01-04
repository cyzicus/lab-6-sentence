package com.cyzicus.client;

import org.springframework.stereotype.Component;

@Component
public class SubjectFallback implements SubjectClient{
    @Override
    public String getSubject() {
        return "We";
    }
}
