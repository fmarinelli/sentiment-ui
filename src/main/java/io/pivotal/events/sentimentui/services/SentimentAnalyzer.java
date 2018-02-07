package io.pivotal.events.sentimentui.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.pivotal.events.sentimentui.domain.AnalyzerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SentimentAnalyzer {

    @Autowired
    private RestTemplate restTemplate;

    public AnalyzerResponse analyze(String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> httpEntity = new HttpEntity<>(content, headers);
        return restTemplate.postForObject("http://sentiment-analyzer/sentiment", httpEntity, AnalyzerResponse.class);
    }

}




































/*
//    @HystrixCommand(fallbackMethod = "noresponse")

    public AnalyzerResponse noresponse(String content) {
        return new AnalyzerResponse();
    }
*/
