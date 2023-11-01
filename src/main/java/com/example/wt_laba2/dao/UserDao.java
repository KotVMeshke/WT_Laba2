package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;

public interface UserDao {
    void signIn(String login, String password) throws DAOException;
    void registration(User user) throws DAOException;
}
