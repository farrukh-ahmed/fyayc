package com.fyayc.Interview.repositories;

import com.fyayc.Interview.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByCode(String code);

    List<ProductEntity> findByPriceBetween(Float startPrice, Float endPrice);

    List<ProductEntity> findByUsersIdAndPriceBetween(Integer userId, Float startPrice, Float endPrice);


}
