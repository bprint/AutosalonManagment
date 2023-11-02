package com.talas.autosalonmanagment.services;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.repositories.ChargingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ChargingsService {
    private final ChargingsRepository chargingsRepository;
    private final ICECarsService iceCarsService;

    @Transactional
    public void add(Charging charging) {
        enrichCharging(charging);
        chargingsRepository.save(charging);
    }

    private void enrichCharging(Charging charging) {
        charging.setIcecar(iceCarsService.findByVin(charging.getIcecar().getVin()).get());

    }
}
