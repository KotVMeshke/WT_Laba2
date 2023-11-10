package com.example.wt_laba2.bean;

public class CartItem {
    public final Product product;
    public final int amount;

    public CartItem(Product prod, int amount) {
        product = prod.Clone();
        this.amount = amount;
    }
    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
