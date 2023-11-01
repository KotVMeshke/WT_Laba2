package com.example.wt_laba2.bean;

public class Product {
    private int id;
    private String productName;
    private String price;
    public String category;
    private String fileName;

    public Product(int id, String productName, String price, String category, String fileName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.fileName = fileName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
