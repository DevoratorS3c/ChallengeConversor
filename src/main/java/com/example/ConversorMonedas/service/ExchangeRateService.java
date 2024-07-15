package com.example.ConversorMonedas.service;
import com.example.ConversorMonedas.model.ConversionRecord;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ExchangeRateService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/4a98e080454a305b69acf329/latest/USD";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    private List<ConversionRecord> conversionHistory = new ArrayList<>();

    public JsonObject getExchangeRates() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), JsonObject.class);
    }

    public void convertCurrency() throws Exception {
        JsonObject rates = getExchangeRates();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la moneda de origen (ejemplo: USD,MNX,EUR,BOB,BRL,CLP,COP):");
        String fromCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda de destino (ejemplo:  USD,MNX,EUR,BOB,BRL,CLP,COP):");
        String toCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese la cantidad a convertir:");
        double amount = scanner.nextDouble();

        double fromRate = rates.get("conversion_rates").getAsJsonObject().get(fromCurrency).getAsDouble();
        double toRate = rates.get("conversion_rates").getAsJsonObject().get(toCurrency).getAsDouble();
        double convertedAmount = amount * (toRate / fromRate);
        LocalDateTime timestamp = LocalDateTime.now();

        ConversionRecord record = new ConversionRecord(fromCurrency, toCurrency, amount, convertedAmount, timestamp);
        conversionHistory.add(record);

        System.out.println(amount + " " + fromCurrency + " equivale a " + convertedAmount + " " + toCurrency);
    }

    public void showConversionHistory() {
        if (conversionHistory.isEmpty()) {
            System.out.println("No hay conversiones realizadas.");
        } else {
            System.out.println("Historial de conversiones:");
            for (ConversionRecord record : conversionHistory) {
                System.out.println(record);
            }
        }
    }
}
