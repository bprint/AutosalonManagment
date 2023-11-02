package com.talas.autosalonmanagment.dto;

import com.talas.autosalonmanagment.model.Car;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CarDTO {

    @NotBlank(message = "Field 'VIN' should not be empty")
    @Size(min = 17, max = 17, message = "The number of characters in the VIN must be exactly 17!")
    private String vin;

    @NotBlank(message = "Field 'brand' should not be empty")
    private String brand;

    @NotBlank(message = "Field 'carModel' should not be empty")
    private String carModel;
}
