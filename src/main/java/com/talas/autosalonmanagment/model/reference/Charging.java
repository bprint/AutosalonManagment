package com.talas.autosalonmanagment.model.reference;

import com.talas.autosalonmanagment.model.BaseEntity;
import com.talas.autosalonmanagment.model.ICECar;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "charging")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Charging extends BaseEntity {

    @NotNull(message = "Field 'chargeDate' should not be empty")
    private LocalDate chargeDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private ICECar icecar;
}
