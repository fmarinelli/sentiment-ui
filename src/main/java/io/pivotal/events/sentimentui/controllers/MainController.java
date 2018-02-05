package io.pivotal.events.sentimentui.controllers;

import io.pivotal.events.sentimentui.domain.AnalyzerResponse;
import io.pivotal.events.sentimentui.services.SentimentAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private SentimentAnalyzer analyzer;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping(value = "/feedback")
    public String sendFeedback(@RequestParam("feedback") String feedback, Model model) {
        AnalyzerResponse analyzerResponse = analyzer.analyze(feedback);


        String response;
        if (analyzerResponse.isValid()) {
            // Positive
            if (analyzerResponse.getScore() > 0) {
                response = "We love to hear it from you.";
            } else {
                response = "Thanks for your feedback, it's sad to hear that you find difficulties with us.";
            }
        } else {
            response = "Thanks for your feedback, we appreciate you to be part of our continuous growth.";
        }
        model.asMap().put("response", response);
        return "feedback";
    }
}
