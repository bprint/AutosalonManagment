package com.talas.autosalonmanagment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name = "ICECar")
public class ICECar extends Car {       //ICE - ДВС (двигатель внутреннего сгорания)

    @ManyToOne
    @JoinColumn(name = "exterior_color_id")
    @NotNull
    private ExteriorColor exteriorColor;

    @ManyToOne
    @JoinColumn(name = "interior_color_id")
    @NotNull
    private InteriorColor interiorColor;

}
