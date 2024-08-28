package com.springboot.jpa.service;

import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.entity.Product;

public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(Product product);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
