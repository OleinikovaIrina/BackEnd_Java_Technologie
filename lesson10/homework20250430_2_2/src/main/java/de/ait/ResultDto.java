package de.ait;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@Getter
@ToString
public class ResultDto {


    private InfoDto info;
    private  double result;
}
