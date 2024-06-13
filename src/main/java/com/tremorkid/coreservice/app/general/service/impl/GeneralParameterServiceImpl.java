package com.tremorkid.coreservice.app.general.service.impl;

import com.tremorkid.coreservice.app.general.beans.GeneralParameterBean;
import com.tremorkid.coreservice.app.general.dao.GeneralParameterDAO;
import com.tremorkid.coreservice.app.general.model.GeneralParameter;
import com.tremorkid.coreservice.app.general.service.GeneralParameterService;
import com.tremorkid.coreservice.shared.base.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j2
@Service
public class GeneralParameterServiceImpl extends BaseService<GeneralParameter, GeneralParameterBean> implements GeneralParameterService {

    @Autowired
    private GeneralParameterDAO generalParameterRepository;

    @Override
    public GeneralParameterBean toBean(GeneralParameter model, Class<GeneralParameterBean> modelClass) {
        GeneralParameterBean bean = new GeneralParameterBean();
        bean.setValue(model.getValue());
        return bean;
    }

    @Override
    public GeneralParameterBean getByCode(String code) {
        Optional<GeneralParameter> generalParameterOptional = generalParameterRepository.findByCode(code);

        if(generalParameterOptional.isEmpty()) {
            throw new NoSuchElementException(String.format("GeneralParameter %s not found", code));
        }

        return toBean(generalParameterOptional.get(), GeneralParameterBean.class);
    }

}