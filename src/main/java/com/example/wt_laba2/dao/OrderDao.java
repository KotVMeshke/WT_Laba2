package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.exception.DAOException;

import java.util.List;

public interface OrderDao {
    void CreateOrder(String address, List<CartItem> cart) throws DAOException;
}
