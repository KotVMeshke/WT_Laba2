package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.bean.User;
import com.example.wt_laba2.dao.ProductDao;
import com.example.wt_laba2.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProductDAO implements ProductDao {

    private static final String connectorDB = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String GetProductsByCat = "Select pro_id, pro_name, pro_price, cat_name,med_filename from product " +
            "join product_category on cat_id = pro_cat join media on med_id = pro_med where cat_name = ?";
    private static final String AddProductIntoCart = "Insert into cart " +
            "(crt_user, crt_product, crt_amount) " +
            "values (?,?,?)";
    private static final String GetAllProducts = "Select pro_id, pro_name, pro_price, cat_name,med_filename from product " +
            "join product_category on cat_id = pro_cat join media on med_id = pro_med";

    private static final String GetProductsFromCart = "Select pro_id, pro_name, pro_price, cat_name,med_filename,crt_amount" +
            "from cart" +
            "join product" +
            "on pro_id = crt_product " +
            "join product_category" +
            "on cat_id = pro_cat" +
            "join media" +
            "on pro_med = med_id where usr_id = ?";

    private static final String GetProductById = "Select pro_id, pro_name, pro_price, cat_name,med_filename " +
            "from product " +
            "join product_category " +
            "on cat_id = pro_cat " +
            "join media " +
            "on med_id = pro_med " +
            "where pro_id = ?";

    @Override
    public List<Product> GetProductListByCat(String category) throws DAOException {
        List<Product> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            ps = con.prepareStatement(GetProductsByCat);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
//        } catch (ClassNotFoundException e) {
//            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return list;
    }

    @Override
    public List<Product> GetAllProduct() throws DAOException {
        List<Product> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            st = con.createStatement();
            rs = st.executeQuery(GetAllProducts);
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
//        } catch (ClassNotFoundException e) {
//            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return list;
    }

    @Override
    public List<CartItem> GetProductsFromCart() throws DAOException {

        List<CartItem> list = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            st = con.createStatement();
            rs = st.executeQuery(GetProductsFromCart);
            while (rs.next()) {
                list.add(new CartItem(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)), rs.getInt(6)));
            }
//        } catch (ClassNotFoundException e) {
//            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return list;

    }

    @Override
    public void AddProductIntoCart(int productId, int userId, int amount) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            ps = con.prepareStatement(AddProductIntoCart);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ps.setInt(3, amount);
            int rowNumber = ps.executeUpdate();
            if (rowNumber == 0) {
                throw new DAOException("Class not found");
            }
//        } catch (ClassNotFoundException e) {
//            throw new DAOException("Class not found");
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
    }

    @Override
    public Product GetProductById(int id) throws DAOException {
        Connection con = null;
        PreparedStatement ps = null;
        Product product = null;
        ResultSet rs = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(connectorDB, "root", "123456");
            ps = con.prepareStatement(GetProductById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
        return product;
    }
}
