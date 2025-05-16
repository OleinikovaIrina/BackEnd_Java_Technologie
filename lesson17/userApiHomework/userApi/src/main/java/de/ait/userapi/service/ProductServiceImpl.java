package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.dto.UserResponseDto;
import de.ait.userapi.mappers.ProductMapper;
import de.ait.userapi.mappers.UserMapper;
import de.ait.userapi.model.Product;
import de.ait.userapi.model.User;
import de.ait.userapi.repository.ProductRepository;
import de.ait.userapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private  final ProductRepository repository;
private  final ProductMapper mapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return mapper.toResponseDtoList(repository.findAll());

    }

    @Override
    public ProductResponseDto getProductById(Long id) {
       return mapper.toResponseDto(repository.findById(id).get());
//        if (product != null) {
//            return toResponseDto(product);
//        } else {
//            throw new RuntimeException("Product not found");
//        }
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto dto) {
        Product product =mapper.fromRequestDto(dto);
        Product savedProduct = repository.save(product);
//        if (savedProduct != null) {
           return mapper.toResponseDto(savedProduct);
//        } else {
//            throw new RuntimeException("Product not found");
//        }

    }

    private static ProductResponseDto toResponseDto(Product product) {
        return new ProductResponseDto(product.getId(), product.getTitle(), product.getPrice());
    }
}


