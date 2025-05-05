package de.ait;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class Main {
    public static void main(String[] args) {

        String url = "https://api.imagga.com/v2/text";
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String token = "Basic YWNjXzU3YjdiZWU2OWM1NGM1MjphZDdlOTUxNGQxNzRjMWRiYjg5MDA3NGEzNTA2ZTRiZQ==";


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);


        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("image_url", imgUrl)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        ResponseEntity<DataResponseDto> response = restTemplate.exchange(request, DataResponseDto.class);

        response.getBody().getResult().getText().forEach(dataDto -> {
            System.out.println(dataDto.getData());
        });
    }
}