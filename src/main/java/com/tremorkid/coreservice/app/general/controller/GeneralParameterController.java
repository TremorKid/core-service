package com.tremorkid.coreservice.app.general.controller;

import com.tremorkid.coreservice.app.general.service.GeneralParameterService;
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
@RequestMapping("/service/general-parameter")
@Tag(name = "GeneralParameterController", description = "GeneralParameter EndPoint")
public class GeneralParameterController {

    @Autowired
    private GeneralParameterService generalParameterService;

    @GetMapping("/{code}")
    public ResponseEntity<?> getGeneralParameter(@PathVariable("code") String code) {
        try {
            return new ResponseEntity<>(generalParameterService.getByCode(code).getValue(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: ", e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}