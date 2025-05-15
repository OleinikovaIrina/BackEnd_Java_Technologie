package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
ProductResponseDto getProductById(Long id);
ProductResponseDto addProduct(ProductRequestDto product);
}
