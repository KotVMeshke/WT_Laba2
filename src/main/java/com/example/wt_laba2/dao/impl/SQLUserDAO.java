package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.bean.UserRoles;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.ConnectionPoolFactory;
import com.example.wt_laba2.pool.ConnectionPool;

import java.sql.*;

/**
 * Implementation of UserDao handling user-related database operations.
 */
public class SQLUserDAO implements UserDao {

    private static String registerNewUser = "INSERT INTO user (idUser, UserLogin, UserPasswordHash,role,ban) Values (null, ?,?,?,?)";
    private static String checkIfUserExist = "Select * from user where userLogin = ? and UserPasswordHash = ?";
    private static String getUserId = "Select idUser, role from user where UserLogin = ?";
    private static String setBan = "Update user " +
            "set ban = true " +
            "where idUser = ?";
    private static String removeBan = "Update user " +
            "set ban = false " +
            "where idUser = ?";

    private static String checkBan = "Select ban from user where idUser = ?";
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Authenticates a user by login and password.
     * @param login The user's login.
     * @param password The user's password.
     * @return The authenticated user.
     * @throws DAOException if there's an error during authentication.
     */
    @Override
    public User signIn(String login, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        User user = new User();
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(checkIfUserExist);
            ps.setString(1, login);
            ps.setString(2, User.getHashSha512Password(password));
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Incorrect login or password");
            }

            ps = con.prepareStatement(getUserId);
            ps.setString(1,login);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Incorrect login or password");
            }else
            {
                user.setId(rs.getInt(1));
                user.setRole(rs.getString(2));
            }
            ps = con.prepareStatement(checkBan);
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                if (rs.getBoolean(1)){
                    throw new DAOException("You were banned");
                }
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(con);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(con);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }

        return user;
    }

    /**
     * Registers a new user.
     * @param user The user object containing registration details.
     * @return The ID of the registered user.
     * @throws DAOException if there's an error during user registration.
     */
    @Override
    public int registration(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        int result = -1;
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(registerNewUser);
            ps.setString(1, user.getLogin());
            ps.setString(2, User.getHashSha512Password(user.getPassword()));
            ps.setString(3, UserRoles.User);
            ps.setString(4, "0");
            ps.executeUpdate();
            ps = con.prepareStatement(getUserId);
            ps.setString(1,user.getLogin());
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Incorrect login or password");
            }else
            {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(con);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(con);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return result;
    }

    /**
     * Sets a ban for a user by their ID.
     * @param userId The ID of the user to be banned.
     * @throws DAOException if there's an error setting the ban.
     */
    @Override
    public Boolean SetBan(int userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(setBan);
            ps.setInt(1,userId);
            int columNumber = ps.executeUpdate();
            if (columNumber < 1){
                throw new DAOException("User with this id: " + String.valueOf(userId) + " doesn't exist");
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(con);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(con);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return true;
    }
    /**
     * Removes a ban for a user by their ID.
     * @param userId The ID of the user to remove the ban.
     * @throws DAOException if there's an error removing the ban.
     */
    @Override
    public Boolean removeBan(int userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            ps = con.prepareStatement(removeBan);
            ps.setInt(1,userId);
            int columNumber = ps.executeUpdate();
            if (columNumber < 1){
                throw new DAOException("User with this id: " + String.valueOf(userId) + " doesn't exist");
            }
        } catch (SQLException e) {
            ConnectionPool.rollbackQuery(con);
            throw new DAOException("Sql error",e);
        } finally {
            try{
                connectionPool.releaseConnection(con);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return true;
    }
}
