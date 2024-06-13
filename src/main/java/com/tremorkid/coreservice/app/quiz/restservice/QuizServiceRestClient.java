package com.tremorkid.coreservice.app.quiz.restservice;

import com.tremorkid.coreservice.app.quiz.beans.QuizRestRequest;
import com.tremorkid.coreservice.app.quiz.beans.QuizRestResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class QuizServiceRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.rest.client.quiz-service}")
    private String url;

    private static final String quiz_SERVICE_PATH = "quiz-service";

    public QuizRestResponse quizChatService(QuizRestRequest request) {
        QuizRestResponse quizRestResponse = new QuizRestResponse();
        try {
            String url = getURL(quiz_SERVICE_PATH);
            quizRestResponse = this.restTemplate.postForObject(url, request, QuizRestResponse.class);
        }
        catch (Exception e) {
            log.error(e);
        }
        return quizRestResponse;
    }

    private String getURL(String path) {
        return url + path;
    }
}
