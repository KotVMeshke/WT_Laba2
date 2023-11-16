package com.example.wt_laba2.service.impl;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.CommandException;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;
import com.example.wt_laba2.factory.DAOFactory;
import com.example.wt_laba2.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String login, String password) throws ServiceException {
        User user = null;
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (login == null || password == null) {
                throw new ServiceException("Incorrect password or login");
            }
            user = userDao.signIn(login, password);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return user;
    }

    @Override
    public int registration(User user) throws ServiceException {
        UserDao userDao = null;
        int id = -1;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (user.getPassword() == null || user.getLogin() == null) {
                throw new ServiceException("Incorrect password or login");
            }
            id = userDao.registration(user);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return id;
    }

    @Override
    public Boolean SetBan(int userId) throws ServiceException {
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (userId <= 0) {
                throw new ServiceException("Incorrect user ID");
            }

            userDao.SetBan(userId);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return true;
    }

    @Override
    public Boolean removeBan(int userId) throws ServiceException {
        UserDao userDao = null;
        try {
            userDao = DAOFactory.getFactory().getUserDao();
            if (userId <= 0) {
                throw new ServiceException("Incorrect user ID");
            }

            userDao.removeBan(userId);

        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
        return true;

    }
}
