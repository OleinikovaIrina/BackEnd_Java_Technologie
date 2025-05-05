package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "https://api.apilayer.com/fixer/convert";
        String token = "Dno6tqrhe1hwukqMCCG4c5bmwTACinZ5";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите валюту, в которую нужно перевести:");
        String to = scanner.nextLine();
        System.out.println("Укажите валюту, из которой производится перевод:");
        String from = scanner.nextLine();
        System.out.println("Укажите сумму:");

        Double amount = scanner.nextDouble();
        scanner.close();


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

        System.out.printf("Сумма: %.2f %s%n", response.getBody().getResult(), to);
        ;

    }
}