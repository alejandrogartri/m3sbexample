package com.alejandrogartri.m3sbexample.service;

import com.alejandrogartri.m3sbexample.model.Product;
import com.alejandrogartri.m3sbexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listProducts() {
        return repository.findAll();
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public Product getProductById(int id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }

    public void deleteProduct(int id) {
        repository.deleteById(id);
    }
}
