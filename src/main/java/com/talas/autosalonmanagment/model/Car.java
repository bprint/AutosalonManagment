package com.talas.autosalonmanagment.model;

import com.talas.autosalonmanagment.model.reference.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Getter @Setter
public abstract class Car extends BaseEntity {

    @Column(name = "vin")
    @NotNull
    final String VIN;                   //VIN code

    @Column(name = "engineNumber")
    @NotNull
    final String engineNumber;

    @ManyToOne
    @JoinColumn(name = "exterior_color_id")
    @NotNull
    final ExteriorColor exteriorColor;

    @ManyToOne
    @JoinColumn(name = "interior_color_id")
    @NotNull
    final InteriorColor interiorColor;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    final Brand brand;                  //Haval, Tank etc.

    @ManyToOne
    @JoinColumn(name = "modelauto_id")
    @NotNull
    final ModelAuto modelAuto;          //H6, Dargo etc.

    @ManyToOne
    @JoinColumn(name = "spec_id")
    @NotNull
    final Spec spec;                    //Elite, Premium, TechPlus

    @NotNull
    final LocalDate arrivedAt;          //Car arrival day

    @NotNull
    final String ttnNumber;             //Waybill number

    @NotNull
    final LocalDate ttnDate;            //Waybill date

    boolean isReadyForSale;             //Pre-sale preparation status

    boolean hasDefects;                 //Has car any defects upon arrival

    DefectsUponArrival defectsUponArrival;  //List of defects upon arrival

    @ManyToOne
    @JoinColumn(name = "carlocation_id")
    @NotNull
    CarLocation carLocation;            //Storage, showroom etc.

    int NumberOfWashes;                 //How many times the car has been washed

    @ManyToOne
    @JoinColumn(name = "extras_id")
    Extras extras;                      //Installed extras

    @OneToOne
    @JoinColumn(name = "battery_charging_id")
    BatteryCharging batteryCharging;    //Dates of all battery charges
}
