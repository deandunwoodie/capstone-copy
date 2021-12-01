package com.example.capstonebackend.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="QUOTES")
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
    private int quoteEngineSize;
    private String quoteNoAdditionalDrivers;
    private String quoteIsCommercial;
    private String quoteIsRegistered;
    private double quoteVehicleValue;
    private String quoteRegistrationDate;

    public void setQuoteTotalCost(double quoteTotalCost) {
        this.quoteTotalCost = quoteTotalCost;
    }

    private double quoteTotalCost;

    public Long getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(Long quoteID) {
        this.quoteID = quoteID;
    }

    public String getQuotePrefix() {
        return quotePrefix;
    }

    public void setQuotePrefix(String quotePrefix) {
        this.quotePrefix = quotePrefix;
    }

    public String getQuoteFirstName() {
        return quoteFirstName;
    }

    public void setQuoteFirstName(String quoteFirstName) {
        this.quoteFirstName = quoteFirstName;
    }

    public String getQuoteLastName() {
        return quoteLastName;
    }

    public void setQuoteLastName(String quoteLastName) {
        this.quoteLastName = quoteLastName;
    }

    public String getQuoteMobile() {
        return quoteMobile;
    }

    public void setQuoteMobile(String quoteMobile) {
        this.quoteMobile = quoteMobile;
    }

    public String getQuoteAddressLine1() {
        return quoteAddressLine1;
    }

    public void setQuoteAddressLine1(String quoteAddressLine1) {
        this.quoteAddressLine1 = quoteAddressLine1;
    }

    public String getQuoteAddressLine2() {
        return quoteAddressLine2;
    }

    public void setQuoteAddressLine2(String quoteAddressLine2) {
        this.quoteAddressLine2 = quoteAddressLine2;
    }

    public String getQuoteCity() {
        return quoteCity;
    }

    public void setQuoteCity(String quoteCity) {
        this.quoteCity = quoteCity;
    }

    public String getQuotePostcode() {
        return quotePostcode;
    }

    public void setQuotePostcode(String quotePostcode) {
        this.quotePostcode = quotePostcode;
    }

    public String getQuoteVehicleType() {
        return quoteVehicleType;
    }

    public void setQuoteVehicleType(String quoteVehicleType) {
        this.quoteVehicleType = quoteVehicleType;
    }

    public int getQuoteEngineSize() {
        return quoteEngineSize;
    }

    public void setQuoteEngineSize(int quoteEngineSize) {
        this.quoteEngineSize = quoteEngineSize;
    }

    public String getQuoteNoAdditionalDrivers() {
        return quoteNoAdditionalDrivers;
    }

    public void setQuoteNoAdditionalDrivers(String quoteNoAdditionalDrivers) {
        this.quoteNoAdditionalDrivers = quoteNoAdditionalDrivers;
    }

    public String getQuoteIsCommercial() {
        return quoteIsCommercial;
    }

    public void setQuoteIsCommercial(String quoteIsCommercial) {
        this.quoteIsCommercial = quoteIsCommercial;
    }

    public String getQuoteIsRegistered() {
        return quoteIsRegistered;
    }

    public void setQuoteIsRegistered(String quoteIsRegistered) {
        this.quoteIsRegistered = quoteIsRegistered;
    }

    public double getQuoteVehicleValue() {
        return quoteVehicleValue;
    }

    public void setQuoteVehicleValue(double quoteVehicleValue) {
        this.quoteVehicleValue = quoteVehicleValue;
    }

    public String getQuoteRegistrationDate() {
        return quoteRegistrationDate;
    }

    public void setQuoteRegistrationDate(String quoteRegistrationDate) {
        this.quoteRegistrationDate = quoteRegistrationDate;
    }

    public double getQuoteTotalCost() {
        return quoteTotalCost;
    }
}
