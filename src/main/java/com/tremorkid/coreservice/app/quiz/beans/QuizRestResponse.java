package com.tremorkid.coreservice.app.quiz.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QuizRestResponse implements Serializable {

    @Expose
    private String response;
}
