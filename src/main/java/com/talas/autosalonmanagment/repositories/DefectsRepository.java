package com.talas.autosalonmanagment.repositories;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.model.reference.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectsRepository extends JpaRepository<Defect, Integer> {
}
