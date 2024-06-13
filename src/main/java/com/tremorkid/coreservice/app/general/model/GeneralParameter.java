package com.tremorkid.coreservice.app.general.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TK_GENERAL_PARAMETER")
public class GeneralParameter implements Serializable {

    @Id
    @Column(name = "TKGP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TKGP_CODE")
    private String code;

    @Column(name = "TKGP_VALU")
    private String value;

    @Column(name = "TKGP_DESC")
    private String description;

}