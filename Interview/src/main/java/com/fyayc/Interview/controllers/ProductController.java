package com.fyayc.Interview.controllers;

import com.fyayc.Interview.common.Meta;
import com.fyayc.Interview.common.Response;
import com.fyayc.Interview.dto.ProductDto;
import com.fyayc.Interview.mapping.MappingContext;
import com.fyayc.Interview.mapping.ProductMapper;
import com.fyayc.Interview.mapping.UserMapper;
import com.fyayc.Interview.services.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")


public class ProductController {

    @Autowired
    ProductService productService;

  //  ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

//    @Autowired
//    UserMapper productMapper;
    UserMapper productMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    MappingContext mappingContext;



    @PostMapping("/")
    public ResponseEntity<Response<ProductDto>> addProduct(@Valid @RequestBody ProductDto product){
        ProductDto productDto =
                productService.addProduct(productMapper.toProduct(product,mappingContext));

        return new ResponseEntity<>(new Response<>(productDto,
                new Meta("Product has been added in the system",HttpStatus.OK.value())), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Response<ProductDto>> updateProduct(@Valid @RequestBody ProductDto product){
        ProductDto productDto =
                productService.updateProduct(productMapper.toProduct(product,mappingContext));

        return new ResponseEntity<>(new Response<>(productDto,
                new Meta("Product has been updated in the system",HttpStatus.OK.value())), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Response<List<ProductDto>>> getAllProducts(){

        return new ResponseEntity<>(new Response<>(productService.getAllProducts(),
                new Meta("Product list fetched successfully.",HttpStatus.OK.value())), HttpStatus.OK);
    }
}