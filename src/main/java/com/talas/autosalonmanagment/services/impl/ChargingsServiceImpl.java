package com.talas.autosalonmanagment.services.impl;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.repositories.ChargingsRepository;
import com.talas.autosalonmanagment.services.ChargingsService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ChargingsServiceImpl implements ChargingsService {
    private final ChargingsRepository chargingsRepository;
    private final ICECarsServiceImpl iceCarsService;

    @Override
    public List<Charging> findAll() {
        return chargingsRepository.findAll();
    }

    @Transactional
    public void add(Charging charging) {
        enrichCharging(charging);
        chargingsRepository.save(charging);
    }

    private void enrichCharging(Charging charging) {
        charging.setIcecar(iceCarsService.findByVin(charging.getIcecar().getVin()).get());

    }
}
