package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;

import java.io.InputStream;
import java.util.List;

public interface ProductDao {
    List<Product> GetProductListByCat(String category) throws DAOException;
    List<Product> GetAllProduct() throws DAOException;
    List<CartItem> GetProductsFromCart() throws DAOException;
    void AddProductIntoCart(int productId, int userId, int amount) throws DAOException;

    void SetDiscount(int productId, int discountSize) throws DAOException;

    void AddProduct(String name,String price, String category, InputStream file) throws DAOException;
    Product GetProductById(int id) throws  DAOException;
}
