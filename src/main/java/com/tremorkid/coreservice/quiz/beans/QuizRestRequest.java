package com.tremorkid.coreservice.quiz.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QuizRestRequest implements Serializable {
    @Expose
    private String request;
}
