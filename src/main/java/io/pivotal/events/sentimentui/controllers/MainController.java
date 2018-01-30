package io.pivotal.events.sentimentui.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping(value = "/feedback")
    public String sendFeedback(@RequestParam("feedback") String feedback, Model model) {
        model.asMap().put("response", "Your feedback is well appreciated");
        return "feedback";
    }
}
