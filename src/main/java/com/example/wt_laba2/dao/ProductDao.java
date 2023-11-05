package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;

import java.util.List;

public interface ProductDao {
    List<Product> GetProductListByCat(String category) throws DAOException;
    List<Product> GetProductListByName(String name) throws DAOException;
    List<Product> GetProduct(String name) throws DAOException;
    List<Product> GetAllProduct() throws DAOException;

    void AddProductIntoCart(int productId, int userId, int amount) throws DAOException;
}
