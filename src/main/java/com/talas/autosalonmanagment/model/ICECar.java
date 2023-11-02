package com.talas.autosalonmanagment.model;

import com.talas.autosalonmanagment.model.reference.Charging;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ICECar extends Car implements Serializable {       //ICE - internal combustion engine

    @NotBlank(message = "Field 'engineVolume' should not be empty")
    private String engineVolume;

   @OneToMany(mappedBy = "icecar")
    private List<Charging> chargings;    //Dates of all battery charges
}
