package com.alejandrogartri.m3sbexample.controller;

import com.alejandrogartri.m3sbexample.model.Product;
import com.alejandrogartri.m3sbexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable int id) {
        try {
            Product existentProduct = productService.getProductById(id);
            existentProduct.setName(product.getName());
            existentProduct.setPrice(product.getPrice());
            productService.saveProduct(existentProduct);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
}
