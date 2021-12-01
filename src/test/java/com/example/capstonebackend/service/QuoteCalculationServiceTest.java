package com.example.capstonebackend.service;

import com.example.capstonebackend.model.Quote;
import com.example.capstonebackend.repository.QuoteRepository;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QuoteCalculationServiceTest {

    @Mock
    private QuoteRepository userRepository;
    @InjectMocks
    private QuoteCalculationService quoteCalculationService;


    // Test Vehicle

    String quoteVehicleType;
    int quoteEngineSize;
    String quoteNoAdditionalDrivers;
    String quoteIsCommerical;
    String quoteIsRegistered;
    double quoteVehicleValue;

    Quote quote;

    @BeforeEach
    void setUp() {

        quote = new Quote();
        quoteVehicleType = "Coupe";
        quoteEngineSize = 1000;
        quoteNoAdditionalDrivers = "3";
        quoteIsCommerical = "Yes";
        quoteIsRegistered = "Yes";
        quoteVehicleValue = 5000.00;

    }

    @Test
    void whenTestQuoteIsCoupeCar_thenCalculateQuoteTotalCost() {

        quoteVehicleType = "Coupe";

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 203.28;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIsHatchbackCar_thenCalculateQuoteTotalCost() {

        quoteVehicleType = "Hatchback";

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 232.32;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIsCabrioletCar_thenCalculateQuoteTotalCost() {

        quoteVehicleType = "Cabriolet";

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 188.76;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIsEstateCar_thenCalculateQuoteTotalCost() {

        quoteVehicleType = "Estate";

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 217.80;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIsOtherCar_thenCalculateQuoteTotalCost() {

        quoteVehicleType = "Other";

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 246.84;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIs1600ccEngineSize_thenCalculateQuoteTotalCost() {

        quoteEngineSize = 1600;

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 325.25;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIs2000ccEngineSize_thenCalculateQuoteTotalCost() {

        quoteEngineSize = 2000;

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 406.56;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIs2500ccEngineSize_thenCalculateQuoteTotalCost() {

        quoteEngineSize = 2500;

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 508.20;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIs3000ccEngineSize_thenCalculateQuoteTotalCost() {

        quoteEngineSize = 3000;

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 609.84;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void whenTestQuoteIsOtherEngineSize_thenCalculateQuoteTotalCost() {

        quoteEngineSize = 5000;

        quote.setQuoteVehicleType(quoteVehicleType);
        quote.setQuoteEngineSize(quoteEngineSize);
        quote.setQuoteNoAdditionalDrivers(quoteNoAdditionalDrivers);
        quote.setQuoteIsCommercial(quoteIsCommerical);
        quote.setQuoteIsRegistered(quoteIsRegistered);
        quote.setQuoteVehicleValue(quoteVehicleValue);

        double expectedResult = 711.48;
        double actualResult = quoteCalculationService.calculateQuote(quote);

        assertEquals(expectedResult, actualResult);

    }

}




