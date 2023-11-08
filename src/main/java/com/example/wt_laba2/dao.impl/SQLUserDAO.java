package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.bean.UserRoles;
import com.example.wt_laba2.dao.UserDao;
import com.example.wt_laba2.exception.DAOException;

import java.sql.*;

public class SQLUserDAO implements UserDao {

    private static String registerNewUser = "INSERT INTO user (idUser, UserLogin, UserPasswordHash,role,ban) Values (null, ?,?,?,?)";
    private static String checkIfUserExist = "Select * from user where userLogin = ? and UserPasswordHash = ?";
    private static String getUserId = "Select idUser, role from user where UserLogin = ?";
    private static String connectorDB ="jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public User signIn(String login, String password) throws DAOException {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        User user = new User();
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
        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {con.close();}
                if (ps != null) {ps.close();}
                if(rs != null) {rs.close();}
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }

        return user;
    }

    @Override
    public int registration(User user) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = -1;
        ResultSet rs= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
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
        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {con.close();}
                if (ps != null) {ps.close();}
                if (rs != null) {rs.close();}
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return result;
    }
}
