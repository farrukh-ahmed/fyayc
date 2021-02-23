package com.fyayc.Interview.services;

import com.fyayc.Interview.dto.ProductDto;
import com.fyayc.Interview.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getAllProductsByUser(long userId);
    List<ProductEntity> getAllProductsByPriceAndUser(Integer startPrice,Integer endPrice,Integer userId);
    ProductEntity findProductById(Integer id);
    String deleteProduct(Integer id);
}
