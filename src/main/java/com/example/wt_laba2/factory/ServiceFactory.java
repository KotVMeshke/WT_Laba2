package com.example.wt_laba2.factory;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.service.OrderService;
import com.example.wt_laba2.service.ProductService;
import com.example.wt_laba2.service.UserService;
import com.example.wt_laba2.service.impl.OrderServiceImpl;
import com.example.wt_laba2.service.impl.ProductServiceImpl;
import com.example.wt_laba2.service.impl.UserServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return instance;
    }
    public OrderService getOrderService(){
        return orderService;
    }
    public ProductService getProductService(){
        return productService;
    }
    public UserService getUserService(){
        return userService;
    }
}
