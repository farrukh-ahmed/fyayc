package com.fyayc.Interview.controllers;

import com.fyayc.Interview.common.Meta;
import com.fyayc.Interview.common.Response;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.services.ProductService;
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

    @PostMapping("/")
    public ResponseEntity<Response<ProductEntity>> addProduct(@Valid @RequestBody ProductEntity product){

        return new ResponseEntity<>(new Response<>(productService.addProduct(product),
                new Meta("Product has been added in the system",HttpStatus.OK.value())), HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Response<ProductEntity>> updateProduct(@Valid @RequestBody ProductEntity product){

        return new ResponseEntity<>(new Response<>(productService.updateProduct(product),
                new Meta("Product has been updated in the system",HttpStatus.OK.value())), HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Response<List<ProductEntity>>> getAllProducts(){

        return new ResponseEntity<>(new Response<>(productService.getAllProducts(),
                new Meta("Product list fetched successfully.",HttpStatus.OK.value())), HttpStatus.OK);
    }

    @GetMapping("/listByPrice")
    public ResponseEntity<Response<List<ProductEntity>>> findProductsByPriceRangeAndUser(
                                                                                  @RequestParam Integer startPrice,
                                                                                  @RequestParam Integer endPrice,
                                                                                  @RequestParam(required = false) Integer userId){
        return new ResponseEntity<>(new Response<>(productService.getAllProductsByPriceAndUser(startPrice,endPrice,userId),
                new Meta("Product list fetched successfully.",HttpStatus.OK.value())), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteProduct(@PathVariable Integer id){
        return new ResponseEntity<>(new Response<>(productService.deleteProduct(id),
                new Meta("Product has been deleted from the system.",HttpStatus.OK.value())), HttpStatus.OK);
    }



}