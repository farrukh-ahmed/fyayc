package com.fyayc.Interview.services.impl;

import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.exceptions.InvalidProductCodeException;
import com.fyayc.Interview.exceptions.InvalidProductIdException;
import com.fyayc.Interview.exceptions.ProductCodeIsNotUniqueException;
import com.fyayc.Interview.repositories.ProductRepository;
import com.fyayc.Interview.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) {
        ProductEntity existingProduct = productRepository.findByCode(productEntity.getCode());
        if (existingProduct != null) throw new ProductCodeIsNotUniqueException();
        else return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        ProductEntity existingProduct = findProductById(productEntity.getId());
        if (existingProduct.getCode().equals(productEntity.getCode())) {
            return productRepository.save(productEntity);
        } else throw new InvalidProductCodeException();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> getAllProductsByUser(long userId) {
        return null;
    }

    @Override
    public List<ProductEntity> getAllProductsByPriceAndUser(Integer startPrice, Integer endPrice, Integer userId) {
        return userId == null ?
                productRepository.findByPriceBetween(startPrice.floatValue(), endPrice.floatValue())
                : productRepository.findByUsersIdAndPriceBetween(userId, startPrice.floatValue(), endPrice.floatValue());
    }

    @Override
    public ProductEntity findProductById(Integer id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) return product.get();
        else throw new InvalidProductIdException();
    }

    @Override
    public String deleteProduct(Integer id) {
        ProductEntity product = findProductById(id);
        if (product.getUsers().size() > 0) throw new RuntimeException("Product with id :" + id + " cannot be deleted");
        else {
            productRepository.delete(product);
            return "Product with id: " + id + " has been deleted.";
        }
    }


}
