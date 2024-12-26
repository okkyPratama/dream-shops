package com.dailycodework.dream_shops.repository;

import com.dailycodework.dream_shops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryNameIgnoreCase(String category);

    List<Product> findByBrandIgnoreCase(String brand);

    List<Product> findByCategoryNameIgnoreCaseAndBrandIgnoreCase(String category, String brand);

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByBrandIgnoreCaseAndNameIgnoreCase(String brand, String name);

    Long countByBrandAndName(String brand, String name);
}
