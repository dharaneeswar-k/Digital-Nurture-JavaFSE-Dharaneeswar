package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}