package com.fyayc.Interview.repositories;

import com.fyayc.Interview.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByCode(String code);
}
