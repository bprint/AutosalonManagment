package com.talas.autosalonmanagment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name = "ICECar")
public class ICECar extends Car {

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    @NotNull
    private Fuel fuel;

    @NotNull
    final String engineValue;


    @ManyToOne
    @JoinColumn(name = "gearbox_id")
    private Gearbox gearbox;

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

}
