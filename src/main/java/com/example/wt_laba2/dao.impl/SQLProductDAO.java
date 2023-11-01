package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.bean.UserRoles;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProductDAO implements ProductDao {

    private static final String connectorDB ="jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";

    private static final String GetProductsByCat = "Select * from product join product_category on pro_category = cat_id where cat_name = ?";
    private static final String GetProductsByName = "Select * from product where pro_name = ?";
    private static final String GetAllProducts = "Select * from product";
    @Override
    public List<Product> GetProductListByCat(String category) throws DAOException {
        return null;
    }

    @Override
    public List<Product> GetProductListByName(String name) throws DAOException {
        return null;
    }

    @Override
    public List<Product> GetProduct(String name) throws DAOException {
        return null;
    }

    @Override
    public List<Product> GetAllProduct() throws DAOException {
        List<Product> list= new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            st = con.createStatement();
            rs = st.executeQuery(GetAllProducts);
            while (rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        "rs.getInt(4)",
                        "rs.getInt(5)"));
            }



        } catch (ClassNotFoundException e) {
            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {con.close();}
                if (st != null) {st.close();}
                if (rs != null) {rs.close();}
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return list;
    }
}
