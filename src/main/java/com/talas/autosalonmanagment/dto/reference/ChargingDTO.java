package com.talas.autosalonmanagment.dto.reference;

import com.talas.autosalonmanagment.model.ICECar;
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

    @NotNull(message = "Field 'chargeDate' should not be empty")
    private LocalDate chargeDate;

    private ICECar icecar;
}
