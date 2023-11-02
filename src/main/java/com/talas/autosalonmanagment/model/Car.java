package com.talas.autosalonmanagment.model;

import com.talas.autosalonmanagment.model.reference.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter @Setter @Table(name = "car")
public abstract class Car extends BaseEntity {

    @NotBlank(message = "Field 'VIN' should not be empty")
    @Size(min = 17, max = 17, message = "The number of characters in the VIN must be exactly 17!")
    private String vin;

    @NotBlank(message = "Field 'brand' should not be empty")
    private String brand;

    @NotBlank(message = "Field 'carModel' should not be empty")
    private String carModel;

}
