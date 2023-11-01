package com.example.wt_laba2.dao;

import com.example.wt_laba2.exception.DAOException;

public interface ProductDao {
    void GetProductListByCat(String category) throws DAOException;
    void GetProductListByName(String name) throws DAOException;
    void GetProduct(String name) throws DAOException;

}
