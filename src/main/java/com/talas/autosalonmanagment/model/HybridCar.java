package com.talas.autosalonmanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Table(name = "hybrid_car")
public class HybridCar extends Car {
}
