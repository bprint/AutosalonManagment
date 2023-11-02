package com.talas.autosalonmanagment.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ICECarDTO extends CarDTO {

    @NotBlank(message = "Field 'engineVolume' should not be empty")
    private String engineVolume;
}
