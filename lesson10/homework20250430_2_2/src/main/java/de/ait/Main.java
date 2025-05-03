package de.ait;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.apilayer.com/fixer/convert";
        String token = "Dno6tqrhe1hwukqMCCG4c5bmwTACinZ5";

        File currencyFile = new File("currency_rates.json");

        Map<String, Double> currencyRates = loadCurrencyRates(currencyFile);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите валюту, в которую нужно перевести:");
        String to = scanner.nextLine();
        System.out.println("Укажите валюту, из которой производится перевод:");
        String from = scanner.nextLine();
        System.out.println("Укажите сумму:");
        Double amount = scanner.nextDouble();
        scanner.close();

        String key = to + " / " + from;
        if (currencyRates.containsKey(key)) {
            double rate = currencyRates.get(key);
            double result = amount * rate;
            System.out.println("Сумма: " + result);
            System.out.println("Курс: " + rate);
        } else {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("apikey", token);

            URI uri = UriComponentsBuilder.fromUriString(url)
                    .queryParam("to", to)
                    .queryParam("from", from)
                    .queryParam("amount", amount)
                    .build()
                    .toUri();
            RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

            ResponseEntity<ResultDto> response = restTemplate.exchange(request, ResultDto.class);
            double rate = response.getBody().getInfo().getRate();
            double result = amount * rate;
            System.out.printf("Сумма: %.2f%n", result);
            System.out.println("Курс: " + rate);
            currencyRates.put(key, rate);
            saveCurrencyRates(currencyFile, currencyRates);


        }
    }

    private static Map<String, Double> loadCurrencyRates(File currencyFile) throws IOException {
        if (currencyFile.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(currencyFile, Map.class);
        } else {
            return new HashMap<>();
        }

    }

    private static void saveCurrencyRates(File currencyFile, Map<String, Double> currencyRates) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(currencyFile, currencyRates);
    }
}
