package com.talas.autosalonmanagment.dto;


import com.fasterxml.jackson.annotation.*;
import com.talas.autosalonmanagment.model.reference.Charging;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ICECarDTO extends CarDTO {

    Long id;

    @NotBlank(message = "Field 'engineVolume' should not be empty")
    private String engineVolume;

    @JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Charging> chargings;
}
