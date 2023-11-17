package com.talas.autosalonmanagment.services;

import com.talas.autosalonmanagment.model.reference.Charging;

import java.util.List;

public interface ChargingsService {

    List<Charging> findAll();

    void add(Charging charging);

}
