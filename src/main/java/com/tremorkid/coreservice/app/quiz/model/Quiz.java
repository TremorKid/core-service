package com.tremorkid.coreservice.app.quiz.model;

import com.tremorkid.coreservice.shared.parse.BooleanToStringConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TK_QUIZ")
public class Quiz implements Serializable {
    @Id
    @Column(name = "TKQ_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TKQ_CRDA")
    private Date creationDate;

    @Column(name = "TKQ_USER")
    private String userName;

    @Column(name = "TKQ_QUE1")
    private String quiz1;

    @Column(name = "TKQ_QUE2")
    private String quiz2;

    @Column(name = "TKQ_QUE3")
    private String quiz3;

    @Column(name = "TKQ_QUE4")
    private String quiz4;

    @Column(name = "TKQ_QUE5")
    private String quiz5;

    @Column(name = "TKQ_QUE6")
    private String quiz6;

    @Column(name = "TKQ_QUE7")
    private String quiz7;

    @Column(name = "TKQ_QUE8")
    private String quiz8;

    @Column(name = "TKQ_QUE9")
    private String quiz9;

    @Column(name = "TKQ_QUE10")
    private String quiz10;

    @Column(name = "TKQ_IFQU")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isFirstQuiz;
}