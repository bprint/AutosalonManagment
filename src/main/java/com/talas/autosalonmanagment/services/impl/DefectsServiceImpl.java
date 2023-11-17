package com.talas.autosalonmanagment.services.impl;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.model.reference.Defect;
import com.talas.autosalonmanagment.repositories.DefectsRepository;
import com.talas.autosalonmanagment.services.DefectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DefectsServiceImpl implements DefectsService {
    private final DefectsRepository defectsRepository;
    private final ICECarsServiceImpl iceCarsService;

    @Override
    public List<Defect> findAll() {
        return defectsRepository.findAll();
    }

    @Transactional
    public void add(Defect defect) {
        enrichDefect(defect);
        defectsRepository.save(defect);
    }

    private void enrichDefect(Defect defect) {
        defect.setCar(iceCarsService.findByVin(defect.getCar().getVin()).get());

    }
}
