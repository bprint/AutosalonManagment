package com.talas.autosalonmanagment.repositories;

import com.talas.autosalonmanagment.model.reference.Charging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingsRepository extends JpaRepository<Charging, Integer> {
}
