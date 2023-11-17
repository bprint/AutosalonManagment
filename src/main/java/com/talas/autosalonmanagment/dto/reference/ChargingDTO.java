package com.talas.autosalonmanagment.dto.reference;

import com.fasterxml.jackson.annotation.*;
import com.talas.autosalonmanagment.model.ICECar;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChargingDTO {

    //Long id;

    @NotNull(message = "Field 'chargeDate' should not be empty")
    private LocalDate chargeDate;

    @JsonBackReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private ICECar icecar;
}
