package com.tremorkid.coreservice.quiz.dao;

import com.tremorkid.coreservice.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Long> {

}
