package de.ait;

//Задание: Получение текущей погоды по городу
//API: OpenWeatherMap
//URL:
//http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric

//http://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=YOUR_API_KEY&units=metric

//Запросить у пользователя название города.
//Сделать HTTP-запрос к API погоды.
//Распарсить ответ:
//Температура main.temp
//Описание погоды weather[0].description
//Вывести результат:
//Пример: В городе Berlin сейчас 18.3°C, ясно



import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.file.WatchEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "http://api.openweathermap.org/data/2.5/weather";
        String token = "3159fd97669d08416193367ed8d64c3f";
        String unit = "metric";

        RestTemplate restTemplate = new RestTemplate();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the city name:");
        String cityName = scanner.nextLine();

        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("q", cityName)
                .queryParam("appid", token)
                .queryParam("units", unit)
                .build()
                .toUri();
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<WeatherDto> response = restTemplate.exchange(request, WeatherDto.class);
        String description = response.getBody().getWeather().get(0).getDescription();
        System.out.println(description);
        double temp= response.getBody().getMain().getTemp();
        System.out.println("Temp: "+temp);
    }


}
