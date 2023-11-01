package com.example.wt_laba2.factory;

import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.dao.impl.SQLProductDAO;
import com.example.wt_laba2.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory hInstance = new DAOFactory();

    private final UserDao sqlUserImpl = new SQLUserDAO();
    private final ProductDao sqlProductImpl = new SQLProductDAO();

    public DAOFactory()    {}

    public static DAOFactory getFactory(){
        return  hInstance;
    }

    public UserDao getUserDao(){
        return  sqlUserImpl;
    }

    public ProductDao getProductDao(){
        return sqlProductImpl;
    }

}
