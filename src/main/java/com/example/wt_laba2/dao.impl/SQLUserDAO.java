package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.bean.UserRoles;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.DAOException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;

public class SQLUserDAO implements UserDao {

    private static String registerNewUser = "INSERT INTO user (idUser, UserLogin, UserPasswordHash,role,ban) Values (null, ?,?,?,?)";
    private static String checkIfUserExist = "Select * from user where userLogin = ? and UserPasswordHash = ?";

    private static String connectorDB ="jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void signIn(String login, String password) throws DAOException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            ps = con.prepareStatement(checkIfUserExist);
            ps.setString(1, login);
            ps.setString(2, User.getHashSha512Password(password));
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Incorrect login or password");
            }
        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {con.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
    }

    @Override
    public void registration(User user) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            ps = con.prepareStatement(registerNewUser);
            ps.setString(1, user.getLogin());
            ps.setString(2, User.getHashSha512Password(user.getPassword()));
            ps.setString(3, UserRoles.User);
            ps.setString(4, "0");
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {con.close();}
                if (ps != null) {ps.close();}
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }

    }
}
