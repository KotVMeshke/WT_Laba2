package com.example.wt_laba2.bean;

public class Product {
    public int id;
    public String productName;
    public String price;
    public String category;
    public String fileName;

    public Product(int id, String productName, String price, String category, String fileName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.fileName = fileName;
    }

    public Product Clone(){
        return new Product(id,productName,price,category,fileName);
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
