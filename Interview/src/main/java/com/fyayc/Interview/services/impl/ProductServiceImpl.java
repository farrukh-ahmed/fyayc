package com.fyayc.Interview.services.impl;

import com.fyayc.Interview.dto.ProductDto;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.exceptions.ProductCodeIsNotUniqueException;
import com.fyayc.Interview.mapping.MappingContext;
import com.fyayc.Interview.mapping.ProductMapper;
import com.fyayc.Interview.mapping.UserMapper;
import com.fyayc.Interview.repositories.ProductRepository;
import com.fyayc.Interview.services.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    UserMapper productMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    MappingContext mappingContext;

    @Override
    public ProductDto addProduct(ProductEntity productEntity) {
        ProductEntity existingProduct = productRepository.findByCode(productEntity.getCode());
        if(existingProduct!=null) throw new ProductCodeIsNotUniqueException();
        else return  productMapper.toProductDto(productRepository.save(productEntity),mappingContext);
    }

    @Override
    public ProductDto updateProduct(ProductEntity productEntity) {
        return productMapper.toProductDto(productRepository.save(productEntity),mappingContext);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productMapper.toProductDtos(productRepository.findAll());
    }


}
