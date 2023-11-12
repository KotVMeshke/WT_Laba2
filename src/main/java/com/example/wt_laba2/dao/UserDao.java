package com.example.wt_laba2.dao;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;

public interface UserDao {
    User signIn(String login, String password) throws DAOException;
    int registration(User user) throws DAOException;

    void SetBan(int userId) throws DAOException;

    void removeBan(int userId) throws DAOException;
}
