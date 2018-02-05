package io.pivotal.events.sentimentui.services;

import io.pivotal.events.sentimentui.domain.AnalyzerResponse;

public interface SentimentAnalyzer {

    String SENTIMENT_ANALYZER_URI = "//sentiment-analyzer/sentiment";

    AnalyzerResponse analyze(String content);
}
