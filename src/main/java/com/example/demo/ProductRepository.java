package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findByNameLike(String searchString);

//    Optional<ProductEntity> findById(String id);

}
