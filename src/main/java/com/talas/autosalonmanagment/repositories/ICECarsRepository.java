package com.talas.autosalonmanagment.repositories;

import com.talas.autosalonmanagment.model.ICECar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICECarsRepository extends JpaRepository<ICECar, Integer> {
    Optional<ICECar> findByVin(String vin);
}
