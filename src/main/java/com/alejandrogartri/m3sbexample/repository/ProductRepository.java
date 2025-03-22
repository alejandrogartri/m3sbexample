package com.alejandrogartri.m3sbexample.repository;

import com.alejandrogartri.m3sbexample.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
