package de.ait.userapi.dto;


import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class ProductRequestDto {

    private String title;
    private BigDecimal price;

}
