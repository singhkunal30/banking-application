package com.banking.gatewayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/accountsFallback")
    public ResponseEntity<String> accountsFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Accounts Service is currently unavailable. Please try again later.");
    }

    @GetMapping("/cardsFallback")
    public ResponseEntity<String> cardsFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Cards Service is currently unavailable. Please try again later.");
    }

    @GetMapping("/loansFallback")
    public ResponseEntity<String> loansFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Loans Service is currently unavailable. Please try again later.");
    }
}
