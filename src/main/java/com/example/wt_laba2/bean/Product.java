package com.example.wt_laba2.bean;

import java.util.Base64;

/**
 * Class representing a product.
 */
public class Product {

    /** The unique identifier for the product. */
    public int id;

    /** The name of the product. */
    public String productName;

    /** The price of the product. */
    public String price;

    /** The category of the product. */
    public String category;

    /** The image of the product in Base64 format. */
    public String image;

    /** The discount percentage for the product. */
    public int discount;

    /** Indicates if the product is in the cart or not. */
    public boolean inCart;

    /**
     * Constructor for creating a product with an image as byte array.
     * @param id          the unique identifier for the product
     * @param productName the name of the product
     * @param price       the price of the product
     * @param discount    the discount percentage for the product
     * @param category    the category of the product
     * @param image       the image of the product as byte array
     */
    public Product(int id, String productName, String price, int discount, String category, byte[] image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = Base64.getEncoder().encodeToString(image);
        this.inCart = false;
    }

    /**
     * Constructor for creating a product with an image as a Base64 string.
     * @param id          the unique identifier for the product
     * @param productName the name of the product
     * @param price       the price of the product
     * @param discount    the discount percentage for the product
     * @param category    the category of the product
     * @param image       the image of the product as a Base64 string
     */
    public Product(int id, String productName, String price, int discount, String category, String image) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.image = image;
    }

    /**
     * Clones the product.
     * @return a new Product object with the same attributes as the original
     */
    public Product Clone() {
        return new Product(id, productName, price, discount, category, image);
    }

    /**
     * Gets the name of the product.
     * @return the name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Gets the discount percentage for the product.
     * @return the discount percentage for the product
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets the discount percentage for the product.
     * @param discount the discount percentage to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Sets the name of the product.
     * @param productName the name of the product to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the price of the product.
     * @return the price of the product
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * @param price the price of the product to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets the category of the product.
     * @return the category of the product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the product.
     * @param category the category of the product to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the unique identifier for the product.
     * @return the unique identifier for the product
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the product.
     * @param id the unique identifier for the product to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the image of the product as a Base64 string.
     * @return the image of the product as a Base64 string
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the image of the product as a Base64 string.
     * @param image the image of the product to set as a Base64 string
     */
    public void setImage(String image) {
        this.image = image;
    }
}
