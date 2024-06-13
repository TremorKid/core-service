package com.tremorkid.coreservice.app.general.beans;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GeneralParameterBean implements Serializable {

    @Expose
    private String value;

}