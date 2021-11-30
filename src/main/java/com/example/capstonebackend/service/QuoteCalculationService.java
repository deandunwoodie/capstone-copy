package com.example.capstonebackend.service;

import com.example.capstonebackend.enumeration.*;
import com.example.capstonebackend.model.Quote;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QuoteCalculationService {

    public double calculateQuote(Quote quote){

        double totalQuote = 100*calculateVehicleTypeFactor(quote)*calculateEngineSizeFactor(quote)
                *calculateAdditionalDriversFactor(quote)
                *calculateCommercialUseFactor(quote)
                *calculateOutsideStateUseFactor(quote)
                *calculateVehicleValueFactor(quote);

        totalQuote = Math.round(totalQuote*100.0)/100.0;

        return totalQuote;
    }


    public double calculateVehicleTypeFactor(Quote quote){

        double vehicleTypeFactor = 0.0;

        String vehicleType = quote.getQuoteVehicleType().toLowerCase(Locale.ROOT);

        switch (vehicleType){
            case "cabriolet":
                vehicleTypeFactor = VehicleTypeFactor.CABRIOLET.getFactorValue();
                break;
            case "coupe":
                vehicleTypeFactor = VehicleTypeFactor.COUPE.getFactorValue();
                break;
            case "estate":
                vehicleTypeFactor = VehicleTypeFactor.ESTATE.getFactorValue();
                break;
            case "hatchback":
                vehicleTypeFactor = VehicleTypeFactor.HATCHBACK.getFactorValue();
                break;
            case "other":
                vehicleTypeFactor = VehicleTypeFactor.OTHER.getFactorValue();
                break;
        }

        return vehicleTypeFactor;
    }

    public double calculateEngineSizeFactor(Quote quote){
        int engineType = quote.getQuoteEngineSize();

        double engineTypeFactor = 0.0;

        switch (engineType){
            case 1000:
                engineTypeFactor = EngineSizeFactor.SIZE1000.getFactorValue();
                break;
            case 1600:
                engineTypeFactor = EngineSizeFactor.SIZE1600.getFactorValue();
                break;
            case 2000:
                engineTypeFactor = EngineSizeFactor.SIZE2000.getFactorValue();
                break;
            case 2500:
                engineTypeFactor = EngineSizeFactor.SIZE2500.getFactorValue();
                break;
            case 3000:
                engineTypeFactor = EngineSizeFactor.SIZE3000.getFactorValue();
                break;
//            case other:
//                engineTypeFactor = EngineSizeFactor.OTHER.getFactorValue();
        }

        return engineTypeFactor;
    }

    public double calculateVehicleValueFactor(Quote quote){
        double vehicleValue = quote.getQuoteVehicleValue();
        double vehicleValueFactor;

        if(vehicleValue <= 5000){
            vehicleValueFactor = VehicleValueFactor.LESSTHAN5000OREQUALTO5000.getFactorValue();
        }
        else{
            vehicleValueFactor = VehicleValueFactor.GREATERTHAN5000.getFactorValue();
        }

        return vehicleValueFactor;
    }

    public double calculateCommercialUseFactor(Quote quote){
        String commercialUseValue = quote.getQuoteIsCommercial();
        double commercialUseFactor;

        if(commercialUseValue == "Yes"){
            commercialUseFactor = CommercialUseFactor.YES.getFactorValue();
        }
        else{
            commercialUseFactor = CommercialUseFactor.NO.getFactorValue();
        }

        return commercialUseFactor;
    }

    public double calculateOutsideStateUseFactor(Quote quote){
        String outsideStateUseValue = quote.getQuoteIsRegistered();
        double outsideStateUseFactor;

        if(outsideStateUseValue  == "Yes") {
            outsideStateUseFactor = OutsideStateUseFactor.YES.getFactorValue();
        }
        else{
            outsideStateUseFactor = OutsideStateUseFactor.NO.getFactorValue();
        }

        return outsideStateUseFactor;
    }

    public double calculateAdditionalDriversFactor(Quote quote){
        String additionalDriversValue = quote.getQuoteNoAdditionalDrivers().toLowerCase(Locale.ROOT);

        double additionalDriversFactor;


        if(Integer.parseInt(additionalDriversValue) < 2){
            additionalDriversFactor = AdditionalDriversFactor.LESSTHAN2.getFactorValue();
        }
        else{
            additionalDriversFactor = AdditionalDriversFactor.GREATERTHANOREQUALTO2.getFactorValue();
        }

        return additionalDriversFactor;
    }

}
