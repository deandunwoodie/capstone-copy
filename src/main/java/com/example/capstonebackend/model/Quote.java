package com.example.capstonebackend.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteID;
    private String quotePrefix;
    private String quoteFirstName;
    private String quoteLastName;
    private String quoteMobile;
    private String quoteAddressLine1;
    private String quoteAddressLine2;
    private String quoteCity;
    private String quotePostcode;
    private String quoteVehicleType;
    private Long quoteEngineSize;
    private String quoteNoAdditionalDrivers;
    private String quoteIsCommercial;
    private String quoteIsRegistered;
    private Long quoteVehicleValue;
    private String quoteRegistrationDate;
}
