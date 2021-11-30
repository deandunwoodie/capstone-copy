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
    Quote getQuoteById(@PathVariable Long quoteID) {
        try {
            return quoteService.getQuoteById(quoteID);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found" + quoteID, noSuchElementException);
        }
    }

    @GetMapping("/hello")
    @CrossOrigin(origins="http://localhost:3000")
    String helloWord(){
        return "Hello World";
    }

    @PostMapping("/quotes")
    @CrossOrigin(origins="http://localhost:3000")
    Quote POSTQuote(@RequestBody Quote Quote) {
        return quoteService.saveQuote(Quote);
    }

    @GetMapping("/quotes")
    List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @DeleteMapping("/quotes/{quoteID}")
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
