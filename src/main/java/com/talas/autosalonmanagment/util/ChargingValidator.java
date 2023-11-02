package com.talas.autosalonmanagment.util;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.services.ICECarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ChargingValidator implements Validator {
    private final ICECarsService icecarsService;

    @Autowired
    public ChargingValidator(ICECarsService icecarsService) {
        this.icecarsService = icecarsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Charging.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Charging charging = (Charging) target;

        if(charging.getIcecar() == null) return;

        if(!icecarsService.findByVin(charging.getIcecar().getVin()).isPresent())
            errors.rejectValue("icecar", "There is no ICECar with that VIN in the database!");
    }
}
