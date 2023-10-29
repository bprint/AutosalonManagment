package com.talas.autosalonmanagment.model.reference;

import com.talas.autosalonmanagment.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "battery_charging")
public class BatteryCharging extends BaseEntity {
    private LocalDate chargeDate;
}
