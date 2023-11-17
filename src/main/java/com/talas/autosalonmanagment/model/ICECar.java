package com.talas.autosalonmanagment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.talas.autosalonmanagment.model.reference.Charging;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ICECar extends Car implements Serializable {       //ICE - internal combustion engine

    @NotBlank(message = "Field 'engineVolume' should not be empty")
    private String engineVolume;

    @OneToMany(mappedBy = "icecar")
    @JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Charging> chargings;    //Dates of all battery charges
}
