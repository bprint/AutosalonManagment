package com.talas.autosalonmanagment.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public abstract class Car extends BaseEntity {

    @Column(name = "vin")
    @NotNull
    final String VIN;

    @Column(name = "engineNumber")
    @NotNull
    final String engineNumber;

}
