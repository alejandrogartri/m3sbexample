package com.alejandrogartri.m3sbexample.model;

import jakarta.persistence.Entity; // Known formerly as javax.persistence
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id @GeneratedValue
    private int id;
    private String name;
    private float price;
}
