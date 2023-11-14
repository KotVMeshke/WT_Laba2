package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.ConnectionPoolFactory;
import com.example.wt_laba2.pool.ConnectionPool;

import java.sql.*;
import java.util.List;

public class SQLOrderDAO implements OrderDao {
    private static final String connectorDB = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";

    public static final String CreateOrder = "INSERT INTO orders " +
            "(ord_id,ord_status,ord_price,ord_address, ord_time_stamp) " +
            "VALUES " +
            "(null, DEFAULT,?,?, Default) ";

    public static final String GetAddedOrderID = "SELECT max(ord_id) from orders";
    public static final String AddOrderProduct = "INSERT INTO order_product " +
            "(op_product, op_order, op_amount) " +
            "VALUES " +
            "(?,?,?)";

    public static float CalculateOrderPrice(List<CartItem> cart){
        float result = 0;
        for (CartItem cartItem : cart) {
            result += cartItem.getAmount() * Float.parseFloat(cartItem.getProduct().getPrice())*(100-cartItem.getProduct().getDiscount())/100;
        }
        return result;
    }
    @Override
    public void CreateOrder(String address, List<CartItem> cart) throws DAOException {
        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
        PreparedStatement ps = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = connectionPool.getConnection();

            ps = con.prepareStatement(CreateOrder);
            ps.setFloat(1, CalculateOrderPrice(cart));
            ps.setString(2, address);
            int lines = ps.executeUpdate();
            if (lines != 1) {
                throw new DAOException("Order creating error");
            }
            st = con.createStatement();
            rs = st.executeQuery(GetAddedOrderID);
            ps = con.prepareStatement(AddOrderProduct);
            if (rs.next()) {
                for (CartItem cartItem : cart) {
                    ps.setInt(1, cartItem.product.getId());
                    ps.setInt(2, rs.getInt(1));
                    ps.setInt(3, cartItem.getAmount());
                    ps.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Sql error");
        } finally {
            try{
                connectionPool.releaseConnection(con);
                ConnectionPool.closeResultSet(rs);
                ConnectionPool.closePreparedStatement(ps);
            } catch (SQLException e) {
                throw new DAOException("SQl connection close error", e);
            }
        }
    }
}
