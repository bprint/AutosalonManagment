package com.talas.autosalonmanagment.services;

import com.talas.autosalonmanagment.model.ICECar;

import java.util.List;
import java.util.Optional;

public interface ICECarsService {
    List<ICECar> findAll();

    ICECar findOne(String vin);

    Optional<ICECar> findByVin(String vin);

    void save(ICECar icecar);

    void update(String vin, String changedVIN, ICECar icecar);

    void delete(String vin);
}
