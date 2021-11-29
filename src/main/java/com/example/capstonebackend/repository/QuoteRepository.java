package com.example.capstonebackend.repository;

import com.example.capstonebackend.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

//    List<Quote> findByFirstNameAndLastName(String firstName, String lastName);


}
