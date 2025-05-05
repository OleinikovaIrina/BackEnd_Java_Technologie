package de.ait;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@Getter
@ToString


public class WeatherDto {

    private List<DescriptionDto> weather;
    private  MainDto main;

}

