package com.talas.autosalonmanagment.services;

import com.talas.autosalonmanagment.model.Car;
import com.talas.autosalonmanagment.model.ICECar;
import com.talas.autosalonmanagment.repositories.ICECarsRepository;
import com.talas.autosalonmanagment.util.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ICECarsService {

    private final ICECarsRepository icecarsRepository;

    public List<ICECar> findAll() {
        return icecarsRepository.findAll();
    }

    public ICECar findOne(int id) {
        Optional<ICECar> foundCar = icecarsRepository.findById(id);
        return foundCar.orElseThrow(NotFoundException::new);
    }

    public Optional<ICECar> findByVin(String vin) {
        return icecarsRepository.findByVin(vin);
    }

    @Transactional
    public void save(ICECar icecar) {
        icecarsRepository.save(icecar);
    }
}
