package com.tremorkid.coreservice.app.quiz.dao;

import com.tremorkid.coreservice.app.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Long> {

}
