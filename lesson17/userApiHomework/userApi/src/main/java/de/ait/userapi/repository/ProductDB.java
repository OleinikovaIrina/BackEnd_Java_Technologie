package de.ait.userapi.repository;

import de.ait.userapi.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class ProductDB {

    private Long lastId =8L;
    private static HashMap<Long, Product> map= new HashMap<>();


    static {
        map.put(1L, new Product(1L, "iPhone 14", new BigDecimal("999.99")));
        map.put(2L, new Product(2L, "Samsung Galaxy S23", new BigDecimal("899.99")));
        map.put(3L, new Product(3L, "MacBook Air", new BigDecimal("1299.00")));
        map.put(4L, new Product(4L, "Dell XPS 15", new BigDecimal("1499.00")));
        map.put(5L, new Product(5L, "PlayStation 5", new BigDecimal("599.99")));
        map.put(6L, new Product(6L, "Xbox Series X", new BigDecimal("549.99")));
        map.put(7L, new Product(7L, "iPad Pro", new BigDecimal("1099.00")));
        map.put(8L, new Product(8L, "Apple Watch", new BigDecimal("399.00")));
    }
public List<Product> getProducts(){
        return map.values().stream().toList();
}
public Product getProductById(Long id){
        return map.get(id);
}
public Product save(Product product) {
        product.setId(++lastId);
        map.put(product.getId(), product);
        return product;
}
}
