package com.tremorkid.coreservice.app.quiz.service;

import com.tremorkid.coreservice.app.quiz.beans.QuizBean;

import java.util.List;

public interface QuizService {

    List<QuizBean> getAllQuizzes();

    QuizBean getById(Long quizId);

    void createQuiz(QuizBean quizBean);

    void updateQuiz(Long quizId, QuizBean quizBean);

    void deleteQuiz(Long quizId);
}
