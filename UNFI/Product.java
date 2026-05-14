package com.maven.model;

public class Product {

    // ENCAPSULATION: Private fields with public accessors
    private String id;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;

    // Default constructor for JSON deserialization
    public Product() {
    }

    // Parameterized constructor
    public Product(String id, String name, String category, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // ENCAPSULATION: Getters (READ-ONLY access)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // ENCAPSULATION: Setter (CONTROLLED access)
    public synchronized void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }

    // BUSINESS LOGIC: Check if product has sufficient stock
    public boolean hasStock(int qty) {
        return stockQuantity >= qty;
    }

    // BUSINESS LOGIC: Reduce stock atomically
    public synchronized boolean reduceStock(int qty) {
        if (hasStock(qty)) {
            this.stockQuantity -= qty;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-22s | Category: %-12s | Price: ₱%-8.2f | Stock: %d",
                id, name, category, price, stockQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
