package com.restful.ecommerce.model.enums;

public enum ProductCategory {
    BEVERAGE("BEVERAGE"),
    COOKIE("COOKIE"),
    DAIRY("DAIRY"),
    MEAT("MEAT"),
    CLEANING("CLEANING");

    private final String label;
    ProductCategory(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
