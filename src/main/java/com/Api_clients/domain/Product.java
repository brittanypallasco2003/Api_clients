package com.Api_clients.domain;

public class Product {

    private Integer ID;
    private String name;
    private Double price;
    private Integer stock;

    public Product(Integer stock, Double price, String name, Integer ID) {
        this.stock = stock;
        this.price = price;
        this.name = name;
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
