package de.ait.demo20250517_1.controllers;

import de.ait.demo20250517_1.model.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {


    @GetMapping("/now")
    public DateTime getTime(){
        LocalDateTime now = LocalDateTime.now();
        return DateTime.builder()
                .month(now.getMonth().getValue())
                .day(now.getDayOfMonth())
                .year(now.getYear())
                .hour(now.getHour())
                .minute(now.getMinute())
                .build();
    }

    @GetMapping("/now2")
    public String getTime2(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"));
    }


}
