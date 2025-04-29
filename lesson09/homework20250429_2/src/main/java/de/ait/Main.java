package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws URISyntaxException {

        //  Ваша программа должна запрашивать номер (id) поста на сайте https://jsonplaceholder.typicode.com/
        //  и получить список всех комментариев для этого поста

        Scanner scanner = new Scanner(System.in);
        int idPost= 0;
try {
    System.out.println("Введите   нужный ID:");
    idPost= scanner.nextInt();
} catch (Exception e) {
    System.out.println("Некорректный ввод");
    scanner.close();
    return;
}
    scanner.close();

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments?postId=" + idPost);
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<List<CommentDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<List<CommentDto>>() {
                });
        List<CommentDto> comments = response.getBody();

        if (comments != null && !comments.isEmpty())  {
            for (CommentDto comment : comments) {
                System.out.println("Комментарии к посту c ID " + idPost + ": " + comment);
                System.out.println();
            }
        } else {
            System.out.println("Такого ID не существует");
        }
    }
}



