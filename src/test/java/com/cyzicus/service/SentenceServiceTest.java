package com.cyzicus.service;

import com.cyzicus.client.*;
import com.cyzicus.config.SentenceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SentenceServiceTest {

    @Mock
    SubjectClient subjectClient;

    @Mock
    VerbClient verbClient;

    @Mock
    ArticleClient articleClient;

    @Mock
    AdjectiveClient adjectiveClient;

    @Mock
    NounClient nounClient;

    SentenceService sentenceService;

    @Before
    public void setUp() throws Exception {
        sentenceService = new SentenceService(subjectClient, verbClient, articleClient,
                adjectiveClient, nounClient);
    }

    @Test
    public void getSentence_returnsSentence() throws Exception {
        when(adjectiveClient.getAdjective()).thenReturn("red");
        when(articleClient.getArticle()).thenReturn("the");
        when(nounClient.getNoun()).thenReturn("pontoon");
        when(subjectClient.getSubject()).thenReturn("I");
        when(verbClient.getVerb()).thenReturn("paddled");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I paddled the red pontoon", sentence);
    }

    @Test
    public void getSentence_handlesArticleCorrectly_a() throws Exception {
        when(adjectiveClient.getAdjective()).thenReturn("beautiful");
        when(articleClient.getArticle()).thenReturn("a");
        when(nounClient.getNoun()).thenReturn("cat");
        when(subjectClient.getSubject()).thenReturn("I");
        when(verbClient.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw a beautiful cat", sentence);
    }

    @Test
    public void getSentence_handlesArticleCorrectly_an() throws Exception {
        when(adjectiveClient.getAdjective()).thenReturn("ugly");
        when(articleClient.getArticle()).thenReturn("a");
        when(nounClient.getNoun()).thenReturn("cat");
        when(subjectClient.getSubject()).thenReturn("I");
        when(verbClient.getVerb()).thenReturn("saw");
        String sentence = sentenceService.getSentence();
        Assert.assertEquals("I saw an ugly cat", sentence);
    }

}