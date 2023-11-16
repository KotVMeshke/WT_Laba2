package com.example.wt_laba2.service;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;

import java.util.List;

public interface OrderService {
    /**
     * Creates an order with the given address and cart items.
     * @param address The address for the order.
     * @param cart The list of cart items to be included in the order.
     * @throws ServiceException if there's an error during order creation.
     */
    void createOrder(String address, List<CartItem> cart) throws ServiceException;
}
