package com.talas.autosalonmanagment.services;

import com.talas.autosalonmanagment.model.reference.Charging;
import com.talas.autosalonmanagment.model.reference.Defect;

import java.util.List;

public interface DefectsService {

    List<Defect> findAll();

    void add(Defect defect);

}
