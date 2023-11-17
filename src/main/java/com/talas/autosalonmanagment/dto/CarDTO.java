package com.talas.autosalonmanagment.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.talas.autosalonmanagment.model.Car;
import com.talas.autosalonmanagment.model.reference.Defect;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CarDTO {

    @NotBlank(message = "Field 'VIN' should not be empty")
    @Size(min = 17, max = 17, message = "The number of characters in the VIN must be exactly 17!")
    private String vin;

    @NotBlank(message = "Field 'engineNumber' should not be empty")
    @Size(min = 10, max = 10, message = "The number of characters in the 'engineNumber' must be exactly 10!")
    private String engineNumber;

    @NotBlank(message = "Field 'brand' should not be empty")
    private String brand;

    @NotBlank(message = "Field 'carModel' should not be empty")
    private String carModel;

    @NotBlank(message = "Field 'spec' should not be empty")
    private String spec;

    @NotBlank(message = "Field 'exteriorColor' should not be empty")
    private String exteriorColor;

    @NotBlank(message = "Field 'interiorColor' should not be empty")
    private String interiorColor;

    @NotNull(message = "Field 'arrivedAt' should not be empty")
    private LocalDate arrivedAt;

    @NotBlank(message = "Field 'ttnNumber' should not be empty")
    private String ttnNumber;

    private Boolean isReadyForSale = false;

    private Boolean hasDefects = false;

    @JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Defect> defects;
}
