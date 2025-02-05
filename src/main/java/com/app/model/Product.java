package com.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products") // Collection name in MongoDB
public class Product {
    @Id
    private String id;
    private String name;
    private double price;

    // Constructors
    public Product() {}
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
