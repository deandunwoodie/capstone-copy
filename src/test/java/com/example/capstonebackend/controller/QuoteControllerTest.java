
package com.example.capstonebackend.controller;

import com.example.capstonebackend.model.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    long dbInitialisedQuoteID;
    Long nonInitialisedQuoteID;
    long quoteID;
    String quotePrefix;
    String quoteFirstName;
    String quoteLastName;
    String quoteMobile;
    String updatedTelephoneNumber;
    String quoteAddressLine1;
    String quoteAddressLine2;
    String quoteCity;
    String quotePostcode;
    String quoteVehicleType;
    int quoteEngineSize;
    String quoteNoAdditionalDrivers;
    String quoteIsCommercial;
    String quoteIsRegistered;
    double quoteVehicleValue;
    String quoteRegistrationDate;
    double quoteTotalCost;

    Quote newQuote;

    @BeforeEach
    void setUp() throws ParseException {

        dbInitialisedQuoteID = 1L;
        nonInitialisedQuoteID = 15L;
        quoteID = 5L;
        quotePrefix = "Mr";
        quoteFirstName = "Dean";
        quoteLastName = "Dunwoodie";
        quoteMobile = "07427262255";
        quoteAddressLine1 = "24 Steph Road";
        quoteAddressLine2 = "Grafton";
        quoteCity = "Portrush";
        quotePostcode = "BT62 1JP";
        quoteVehicleType = "Cabriolet";
        quoteEngineSize = 1000;
        quoteNoAdditionalDrivers = "2";
        quoteIsCommercial = "Yes";
        quoteIsRegistered = "No";
        quoteVehicleValue = 12500.00;
        quoteRegistrationDate = "27/10/2020";
        quoteTotalCost = 0.00;

        newQuote = new Quote(quoteID, quotePrefix, quoteFirstName, quoteLastName, quoteMobile, quoteAddressLine1, quoteAddressLine2, quoteCity, quotePostcode, quoteVehicleType, quoteEngineSize, quoteNoAdditionalDrivers, quoteIsCommercial, quoteIsRegistered, quoteVehicleValue, quoteRegistrationDate, quoteTotalCost);
    }


    @Test
    void givenDatabaseWith2Quotes_getNonExistingEndpoint404() throws Exception {
        mockMvc
                .perform(get("/NOT-AN-ENDPOINT"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    void givenDatabaseWith2Quotes_whenGetAllQuotesInDB_thenStatusOK200() throws Exception {

        mockMvc.perform(get("/quotes"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void givenDatabaseWith2Quotes_whenGetQuoteByID_thenStatusShouldReturn200() throws Exception {

        mockMvc.perform(get("/quotes/" + dbInitialisedQuoteID))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void givenDatabaseWith2Quotes_whenGetNonExistingQuoteByID_thenShouldReturnStatusNotFound() throws Exception {

        mockMvc
                .perform(get("/quotes/" + nonInitialisedQuoteID)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

    }

    @Test
    @DirtiesContext
    void givenDatabaseWith2Quotes_whenPOSTQuoteWithJSON_thenSaveQuoteAndReturnStatusOK() throws Exception {

        String quoteAsString = objectMapper.writeValueAsString(newQuote);

        final MvcResult mvcResult = mockMvc
                .perform(post("/quotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(quoteAsString)
                )
                .andDo(print())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        Quote postedQuote = objectMapper.readValue(contentAsString, Quote.class);

        assertAll(
                () -> assertNotNull(postedQuote.getQuoteID()),
                () -> assertEquals(quotePrefix, postedQuote.getQuotePrefix()),
                () -> assertEquals(quoteFirstName, postedQuote.getQuoteFirstName()),
                () -> assertEquals(quoteLastName, postedQuote.getQuoteLastName()),
                () -> assertEquals(quoteMobile, postedQuote.getQuoteMobile()),
                () -> assertEquals(quoteAddressLine1, postedQuote.getQuoteAddressLine1()),
                () -> assertEquals(quoteAddressLine2, postedQuote.getQuoteAddressLine2()),
                () -> assertEquals(quoteCity, postedQuote.getQuoteCity()),
                () -> assertEquals(quotePostcode, postedQuote.getQuotePostcode()),
                () -> assertEquals(quoteVehicleType, postedQuote.getQuoteVehicleType()),
                () -> assertEquals(quoteEngineSize, postedQuote.getQuoteEngineSize()),
                () -> assertEquals(quoteNoAdditionalDrivers, postedQuote.getQuoteNoAdditionalDrivers()),
                () -> assertEquals(quoteIsCommercial, postedQuote.getQuoteIsCommercial()),
                () -> assertEquals(quoteIsRegistered, postedQuote.getQuoteIsRegistered()),
                () -> assertEquals(quoteVehicleValue, postedQuote.getQuoteVehicleValue(), 0.2),
                () -> assertEquals(quoteRegistrationDate, postedQuote.getQuoteRegistrationDate())
        );
    }


    @Test
    void givenDatabaseWith2Quotes_whenGetAllQuotesInDB_thenShouldReturnBothQuotesAndStatusOK200() throws Exception {

        final MvcResult mvcResult = mockMvc
                .perform(get("/quotes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        List<Quote> quotes = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });

        assertEquals(2, quotes.size());
    }
}