package com.talas.autosalonmanagment.util;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.model.reference.Defect;
import com.talas.autosalonmanagment.services.impl.ICECarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DefectValidator implements Validator {
    private final ICECarsServiceImpl icecarsService;

    @Autowired
    public DefectValidator(ICECarsServiceImpl icecarsService) {
        this.icecarsService = icecarsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Defect.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Defect defect = (Defect) target;

        if(defect.getCar() == null) return;

        if(!icecarsService.findByVin(defect.getCar().getVin()).isPresent())
            errors.rejectValue("icecar", "There is no ICECar with that VIN in the database!");
    }
}
