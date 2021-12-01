package com.example.capstonebackend.service;

import com.example.capstonebackend.model.Quote;
import com.example.capstonebackend.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final QuoteCalculationService quoteCalculationService;
    List<Quote> quotes = new ArrayList<>();

    public QuoteService(QuoteRepository quoteRepository, QuoteCalculationService quoteCalculationService) {
        this.quoteRepository = quoteRepository;
        this.quoteCalculationService = quoteCalculationService;
    }

    public List<Quote> getAllQuotes (){
        return quoteRepository.findAll();
    }

    // C - CREATE
    public Quote saveQuote(Quote quote){
        quote.setQuoteTotalCost(quoteCalculationService.calculateQuote(quote));
        quotes.add(quote);
        return quoteRepository.save(quote);
    }

    // R - READ
    public Quote getQuoteById(Long quoteID) throws NoSuchElementException {
        return quoteRepository.findById(quoteID)
                .orElseThrow(() -> new NoSuchElementException("No Quote With ID " + quoteID));
    }

    // U - UPDATE
    public Quote updateQuoteById(Quote quote, Long quoteID) {
        return quoteRepository.findById(quoteID)
                .map(q -> {
                    q.setQuoteMobile(quote.getQuoteMobile());
                    return quoteRepository.save(q);
                })
                .orElseThrow(() -> new NoSuchElementException("No Quote With ID " + quoteID));
    }

    // D - DELETE
    public void deleteQuoteById(Long quoteID) {
        quoteRepository.deleteById(quoteID);
    }
}
