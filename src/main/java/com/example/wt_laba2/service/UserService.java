package com.example.wt_laba2.service;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.exception.ServiceException;

public interface UserService {
    /**
     * Validates user sign-in credentials.
     * @param login The user's login username.
     * @param password The user's password.
     * @return User object if the login is successful.
     * @throws DAOException if there's an error during sign-in.
     */
    User signIn(String login, String password) throws ServiceException;

    /**
     * Registers a new user.
     * @param user The user object containing registration details.
     * @return ID of the registered user.
     * @throws DAOException if there's an error during registration.
     */
    int registration(User user) throws ServiceException;

    /**
     * Sets a ban for a specific user.
     * @param userId The ID of the user to be banned.
     * @throws DAOException if there's an error while setting the ban.
     */
    Boolean SetBan(int userId) throws ServiceException;

    /**
     * Removes the ban for a specific user.
     * @param userId The ID of the user from whom the ban should be removed.
     * @throws DAOException if there's an error while removing the ban.
     */
    Boolean removeBan(int userId) throws ServiceException;
}
