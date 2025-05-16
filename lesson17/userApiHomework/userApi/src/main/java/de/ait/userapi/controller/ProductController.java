package de.ait.userapi.controller;


import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.dto.UserRequestDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        return service.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public ProductResponseDto getById(@PathVariable(name = "id") Long id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto dto){
        return service.addProduct(dto);
    }



}
