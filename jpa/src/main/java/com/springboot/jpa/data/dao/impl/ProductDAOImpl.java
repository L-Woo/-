package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.ProductDAO;
import com.springboot.jpa.entity.Product;
import com.springboot.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectProduct = productRepository.getReferenceById(number);
        return selectProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);

        Product updatedProduct;
        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();

//            product.setName(name);
//            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(
                    Product.builder()
                            .number(product.getNumber())
                            .name(name)
                            .price(product.getPrice())
                            .stock(product.getStock())
                            .updatedAt(LocalDateTime.now())
                            .build());
        }else {
            throw new Exception();
        }
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);

        if(selectProduct.isPresent()) {
            Product product = selectProduct.get();

            productRepository.delete(product);
        }else {
            throw new Exception();
        }
    }
}
