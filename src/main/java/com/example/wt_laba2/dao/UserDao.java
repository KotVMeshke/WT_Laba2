package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;

public interface UserDao {
    int signIn(String login, String password) throws DAOException;
    int registration(User user) throws DAOException;
}
