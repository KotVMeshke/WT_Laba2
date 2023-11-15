package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.exception.DAOException;

import java.util.List;

/**
 * Interface handling order-related database operations.
 */
public interface OrderDao {

    /**
     * Creates an order with the given address and cart items.
     * @param address The address for the order.
     * @param cart The list of cart items to be included in the order.
     * @throws DAOException if there's an error during order creation.
     */
    void CreateOrder(String address, List<CartItem> cart) throws DAOException;
}
