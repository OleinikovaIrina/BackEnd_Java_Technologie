package de.ait.demo20250514_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo202505142Application {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(Demo202505142Application.class, args);
        System.out.println("qwert");
    }
}