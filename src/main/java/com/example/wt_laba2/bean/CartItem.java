package com.example.wt_laba2.bean;

/**
 * Class representing a cart item.
 */
public class CartItem {

    /** The product associated with the cart item. */
    public Product product;

    /** The quantity of this product in the cart. */
    public int amount;

    /**
     * Constructor for creating a cart item.
     * @param prod   the product to be associated with the cart item
     * @param amount the quantity of this product in the cart
     */
    public CartItem(Product prod, int amount) {
        product = prod.Clone(); // Cloning the product to avoid issues with modifying the original object
        this.amount = amount;
    }

    /**
     * Get the product associated with the cart item.
     * @return the product associated with the cart item
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Get the quantity of this product in the cart.
     * @return the quantity of this product in the cart
     */
    public int getAmount() {
        return amount;
    }
}
