package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        //  Ваша задача написать программу, которая получает List комментариев
      //   (объекты коллекции) comments на сайте https://jsonplaceholder.typicode.com/

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");
        RequestEntity<String> request= new RequestEntity<>(HttpMethod.GET,uri);
     ResponseEntity<List<CommentDto>> response=
              restTemplate.exchange(request, new ParameterizedTypeReference<List<CommentDto>>() { });
       List<CommentDto> comments = response.getBody();
       for (CommentDto comment: comments){
           System.out.println(comment);
           System.out.println();
       }
    }
}
