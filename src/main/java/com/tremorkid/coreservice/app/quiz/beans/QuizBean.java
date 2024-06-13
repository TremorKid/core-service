package com.tremorkid.coreservice.app.quiz.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class QuizBean implements Serializable {
    @Expose
    private String userName;

    @Expose
    private String quiz1;

    @Expose
    private String quiz2;

    @Expose
    private String quiz3;

    @Expose
    private String quiz4;

    @Expose
    private String quiz5;

    @Expose
    private String quiz6;

    @Expose
    private String quiz7;

    @Expose
    private String quiz8;

    @Expose
    private String quiz9;

    @Expose
    private String quiz10;
}