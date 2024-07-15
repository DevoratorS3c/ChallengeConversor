package com.example.ConversorMonedas.model;

import java.time.LocalDateTime;

public class ConversionRecord {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private LocalDateTime timestamp;

    public ConversionRecord(String fromCurrency, String toCurrency, double amount, double convertedAmount, LocalDateTime timestamp) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Conversion from " + amount + " " + fromCurrency + " to " + convertedAmount + " " + toCurrency + " at " + timestamp;
    }
}
