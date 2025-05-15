package de.ait.userapi.mappers;


import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDto toResponseDto(Product product);
    List<ProductResponseDto> toResponseDtoList(List<Product> products);
    Product fromRequestDto(ProductRequestDto dto);
}
