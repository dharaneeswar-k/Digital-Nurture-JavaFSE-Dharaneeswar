package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private double cpuSpeed;
    private int ramSize;
    private int hddSize;
    private String operatingSystem;
    private String cpu;
    private double weight;
    private int customerReview;

}
