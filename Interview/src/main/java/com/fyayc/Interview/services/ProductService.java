package com.fyayc.Interview.services;

import com.fyayc.Interview.dto.ProductDto;
import com.fyayc.Interview.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductDto addProduct(ProductEntity productEntity);
    ProductDto updateProduct(ProductEntity productEntity);
    List<ProductDto> getAllProducts();
}
