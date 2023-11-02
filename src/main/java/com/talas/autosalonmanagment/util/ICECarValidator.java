package com.talas.autosalonmanagment.util;

import com.talas.autosalonmanagment.model.ICECar;
import com.talas.autosalonmanagment.services.ICECarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ICECarValidator implements Validator {
    private final ICECarsService icecarsService;

    @Autowired
    public ICECarValidator(ICECarsService icecarsService) {
        this.icecarsService = icecarsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ICECar.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ICECar icecar =(ICECar) target;

        if(icecarsService.findByVin(icecar.getVin()).isPresent())
            errors.rejectValue("vin", "A car with the same VIN already exist");
    }
}
