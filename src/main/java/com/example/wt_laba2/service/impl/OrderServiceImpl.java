package com.example.wt_laba2.service.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(String address, List<CartItem> cart) throws ServiceException {
        try{
            if (address != null && cart != null) {
                OrderDao orderDao = DAOFactory.getFactory().getOrderDao();
                orderDao.CreateOrder(address, cart);
            }
        }catch (DAOException ex){
            throw new ServiceException(ex);
        }

    }
}
