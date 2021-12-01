package com.example.capstonebackend.controller;
import com.example.capstonebackend.model.Quote;
import com.example.capstonebackend.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes/{quoteID}")
    @CrossOrigin(origins="http://localhost:3000")
    Quote getQuoteById(@PathVariable Long quoteID) {
        try {
            return quoteService.getQuoteById(quoteID);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found" + quoteID, noSuchElementException);
        }
    }

    @PostMapping("/quotes")
    @CrossOrigin(origins="http://localhost:3000")
    Quote POSTQuote(@RequestBody Quote Quote) {
        return quoteService.saveQuote(Quote);
    }

    @GetMapping("/quotes")
    @CrossOrigin(origins="http://localhost:3000")
    List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }


    @PutMapping("/quotes/{quoteID}")
    @CrossOrigin(origins="http://localhost:3000")
    Quote updateDriverById(@RequestBody Quote quoteUpdate, @PathVariable Long quoteID) {
        try {
            return quoteService.updateQuoteById(quoteUpdate, quoteID);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Quote ID Not Found" + quoteID, noSuchElementException);
        }
    }

    @DeleteMapping("/quotes/{quoteID}")
    @CrossOrigin(origins="http://localhost:3000")
    ResponseEntity<Long> deleteQuoteById(@PathVariable Long quoteID) {
        try {
            quoteService.getQuoteById(quoteID);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, quoteID + "not found", noSuchElementException);
        }
        quoteService.deleteQuoteById(quoteID);
        return new ResponseEntity<>(quoteID, HttpStatus.OK);
    }

}
