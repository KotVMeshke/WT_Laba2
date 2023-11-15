package com.example.wt_laba2.factory;

import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.dao.impl.SQLOrderDAO;
import com.example.wt_laba2.dao.impl.SQLProductDAO;
import com.example.wt_laba2.dao.impl.SQLUserDAO;

/**
 * Factory class responsible for providing DAO instances.
 */
public class DAOFactory {
    private static final DAOFactory hInstance = new DAOFactory();

    private final UserDao sqlUserImpl = new SQLUserDAO();
    private final ProductDao sqlProductImpl = new SQLProductDAO();
    private final OrderDao sqlOrderImpl = new SQLOrderDAO();

    /**
     * Private constructor to prevent direct instantiation from outside the class.
     */
    private DAOFactory() {}

    /**
     * Returns the singleton instance of the DAOFactory.
     * @return The instance of DAOFactory.
     */
    public static DAOFactory getFactory(){
        return  hInstance;
    }

    /**
     * Retrieves an instance of UserDao.
     * @return The UserDao instance.
     */
    public UserDao getUserDao(){
        return  sqlUserImpl;
    }

    /**
     * Retrieves an instance of ProductDao.
     * @return The ProductDao instance.
     */
    public ProductDao getProductDao(){
        return sqlProductImpl;
    }

    /**
     * Retrieves an instance of OrderDao.
     * @return The OrderDao instance.
     */
    public OrderDao getOrderDao(){
        return sqlOrderImpl;
    }
}
