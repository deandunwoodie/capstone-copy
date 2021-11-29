package com.example.capstonebackend.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {



    @GetMapping("/hello")
    @CrossOrigin(origins="http://localhost:3000")
    String helloWord(){
        return "Hello World";
    }

}
