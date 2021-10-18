package com.restful.ecommerce.model.enums;

public enum ProductCategory {
    BEVERAGE("BEVERAGE"),
    COOKIE("COOKIE"),
    DAIRY("DAIRY"),
    MEAT("MEAT"),
    CLEANING("CLEANING");

    private final String name;
    ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
