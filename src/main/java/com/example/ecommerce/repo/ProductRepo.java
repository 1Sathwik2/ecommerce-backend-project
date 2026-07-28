package com.example.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
