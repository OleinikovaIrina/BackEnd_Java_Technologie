package de.ait;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@ToString

public class TagDto {
    private  double confidence;
    private Map<String,String> tag;






}
