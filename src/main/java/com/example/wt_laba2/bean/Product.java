package com.example.wt_laba2.bean;

import java.util.Base64;

public class Product {
    public int id;
    public String productName;
    public String price;
    public String category;

    public String image;
    public int discount;

    public Product(int id, String productName, String price,int discount, String category ,byte[] image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = Base64.getEncoder().encodeToString(image);
    }
    public Product(int id, String productName, String price,int discount, String category ,String image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = image;
    }

    public Product Clone(){
        return new Product(id,productName,price,discount,category, image);
    }
    public String getProductName() {
        return productName;
    }
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
