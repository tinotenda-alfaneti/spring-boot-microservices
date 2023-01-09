package com.atarist.productservice.service;


import com.atarist.productservice.dto.ProductRequest;
import com.atarist.productservice.dto.ProductResponse;
import com.atarist.productservice.model.Product;
import com.atarist.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //to make springboot know that this is a service
@RequiredArgsConstructor //allows for creation of any required constructors
@Slf4j //for adding logs
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest) {

        //creating the product using the lombok build
        Product product = Product.builder()
                .name(productRequest.getName())
                .descriptions(productRequest.getDescriptions())
                .price(productRequest.getPrice())
                .build();
        //Saving the product to database
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());


    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .descriptions(product.getDescriptions())
                .price(product.getPrice())
                .build();
    }
}
