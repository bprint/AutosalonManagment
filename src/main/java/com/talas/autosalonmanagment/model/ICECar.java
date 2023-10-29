package com.talas.autosalonmanagment.model;

import com.talas.autosalonmanagment.model.reference.Fuel;
import com.talas.autosalonmanagment.model.reference.Gearbox;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name = "icecar")
public class ICECar extends Car {       //ICE - internal combustion engine

    @ManyToOne
    @JoinColumn(name = "fuel_id")
    @NotNull
    final Fuel fuel;                    //Type of fuel used

    @ManyToOne
    @JoinColumn(name = "gearbox_id")
    @NotNull
    final Gearbox gearbox;              //Type of transmission used

    @NotNull
    final double engineVolume;
}
