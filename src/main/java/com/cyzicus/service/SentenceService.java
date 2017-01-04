package com.cyzicus.service;

import com.cyzicus.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {

    private final SubjectClient subjectClient;
    private final VerbClient verbClient;
    private final ArticleClient articleClient;
    private final AdjectiveClient adjectiveClient;
    private final NounClient nounClient;

    @Autowired
    public SentenceService(SubjectClient subjectClient, VerbClient verbClient,
                           ArticleClient articleClient, AdjectiveClient adjectiveClient,
                           NounClient nounClient) {
        this.subjectClient = subjectClient;
        this.verbClient = verbClient;
        this.articleClient = articleClient;
        this.adjectiveClient = adjectiveClient;
        this.nounClient = nounClient;
    }

    public String getSentence() {

        String subject = subjectClient.getSubject();
        String verb = verbClient.getVerb();
        String article = articleClient.getArticle();
        String adjective = adjectiveClient.getAdjective();
        String noun = nounClient.getNoun();

        return String.format("%s %s %s %s %s", subject, verb, correctArticle(article, adjective), adjective, noun);
    }

    private String correctArticle(String article, String adjective) {
        if (article.toLowerCase().equals("a")) {
            if (isVowel(adjective.charAt(0))) {
                return "an";
            }
        }
        return article;

    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

}
