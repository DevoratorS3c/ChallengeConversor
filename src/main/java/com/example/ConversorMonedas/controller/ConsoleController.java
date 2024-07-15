package com.example.ConversorMonedas.controller;



import com.example.ConversorMonedas.service.ExchangeRateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleController implements CommandLineRunner {
    private final ExchangeRateService exchangeRateService;

    public ConsoleController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("----------------------------------------");
            System.out.println("-------------*-MadeByDavidMoya-*-------");
            System.out.println("Buen dia, Gracias por usar mi Aplicación");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exchangeRateService.convertCurrency();
                    break;
                case 2:
                    exchangeRateService.showConversionHistory();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
