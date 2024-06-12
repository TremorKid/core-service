package com.tremorkid.coreservice.quiz.service.impl;

import com.tremorkid.coreservice.quiz.beans.QuizBean;
import com.tremorkid.coreservice.quiz.service.QuizService;
import com.tremorkid.coreservice.quiz.model.Quiz;
import com.tremorkid.coreservice.quiz.dao.QuizDAO;
import com.tremorkid.coreservice.shared.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
@Service
public class QuizServiceImpl extends BaseService<Quiz, QuizBean> implements QuizService {

    @Autowired
    private QuizDAO quizRepository;

//    @Autowired
//    private QuizServiceRestClient quizServiceRestClient;
//
//    public QuizRestResponse quizChatService(QuizRestRequest quizRestRequest) {
//        return quizServiceRestClient.quizChatService(quizRestRequest);
//    }

    @Override
    public QuizBean toBean(Quiz model, Class<QuizBean> modelClass) {
        QuizBean bean = new QuizBean();
        BeanUtils.copyProperties(model, bean);
        return bean;
    }

    @Override
    public List<QuizBean> getAllQuizzes() {
        List<QuizBean> list = new ArrayList<>();
        List<Quiz> quizs =  quizRepository.findAll();

        for (Quiz quiz : quizs) {
            list.add(toBean(quiz, QuizBean.class));
        }

        return list;
    }

    @Override
    public QuizBean getById(Long quizId) {
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Quiz %s not found", quizId));
        }

        return toBean(quizOptional.get(), QuizBean.class);
    }

    @Override
    public void createQuiz(QuizBean quizBean) {
        Quiz quiz = toModel(quizBean, Quiz.class);
        quiz.setCreationDate(new Date());
        quizRepository.save(quiz);
    }

    @Override
    public void updateQuiz(Long quizId, QuizBean quizBean) {
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Quiz %s not found", quizId));
        }

        quizRepository.save(toModel(quizBean, Quiz.class));
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Optional<Quiz> quizOptional = quizRepository.findById(quizId);

        if(quizOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("Quiz %s not found", quizId));
        }

        quizRepository.delete(quizOptional.get());
    }
}