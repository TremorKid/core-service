package com.tremorkid.coreservice.app.general.dao;

import com.tremorkid.coreservice.app.general.model.GeneralParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneralParameterDAO extends JpaRepository<GeneralParameter, Long> {

    Optional<GeneralParameter> findByCode(String code);

}
