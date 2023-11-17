package com.talas.autosalonmanagment.model.reference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.talas.autosalonmanagment.model.BaseEntity;
import com.talas.autosalonmanagment.model.Car;
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
@Table(name = "defect")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Defect extends BaseEntity {

    private LocalDate eliminationDate;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonBackReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private Car car;
}
