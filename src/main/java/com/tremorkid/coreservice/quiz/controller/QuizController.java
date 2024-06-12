package com.tremorkid.coreservice.quiz.controller;

import com.tremorkid.coreservice.quiz.beans.QuizBean;
import com.tremorkid.coreservice.quiz.service.QuizService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Api
@RestController
@RequestMapping("/service/quiz")
@Tag(name = "QuizController", description = "Quiz EndPoint")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(quizService.getAllQuizzes(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long quizId) {
        try {
            return new ResponseEntity<>(quizService.getById(quizId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createQuiz(@RequestBody QuizBean quizBean) {
        try {
            quizService.createQuiz(quizBean);
            return new ResponseEntity<>("created", HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<?> updateQuiz(@PathVariable("id") Long quizId, @RequestBody QuizBean quizBean) {
//        try {
//            quizService.updateQuiz(quizId, quizBean);
//            return new ResponseEntity<>("updated", HttpStatus.OK);
//        } catch (Exception e) {
//            log.error(e);
//            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteQuiz(@PathVariable("id") Long quizId) {
//        try {
//            quizService.deleteQuiz(quizId);
//            return new ResponseEntity<>("deleted", HttpStatus.OK);
//        } catch (Exception e) {
//            log.error(e);
//            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}