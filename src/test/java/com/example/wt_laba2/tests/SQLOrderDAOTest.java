package com.example.wt_laba2.tests;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.ConnectionPoolFactory;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.pool.ConnectionPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLOrderDAOTest {

    @Test
    void createOrder() throws DAOException {
        try{
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

            connectionPool.CreateConnections();

        }catch (Exception ex){
            Assertions.fail("Problem with connection");
        }
        OrderDao orderDao = DAOFactory.getFactory().getOrderDao();
        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem(new Product(7,"Iphone 14","1199",0,"Phone",new byte[10]),3));
        orderDao.CreateOrder("Some addressssssss",cart);

    }
}