package com.example.wt_laba2.dao.impl;

import com.example.wt_laba2.bean.CartItem;
import com.example.wt_laba2.bean.Product;
import com.example.wt_laba2.dao.OrderDao;
import com.example.wt_laba2.exception.DAOException;
import com.example.wt_laba2.factory.ConnectionPoolFactory;
import com.example.wt_laba2.pool.ConnectionPool;

import java.sql.*;
import java.util.Dictionary;
import java.util.List;

/**
 * Implementation of OrderDao that handles orders using an SQL database.
 */
public class SQLOrderDAO implements OrderDao {

    /** SQL statement to create an order in the database. */
    public static final String CreateOrder = "INSERT INTO orders " +
            "(ord_id,ord_status,ord_price,ord_address, ord_time_stamp) " +
            "VALUES " +
            "(null, DEFAULT,?,?, Default) ";

    /** SQL statement to retrieve the ID of the recently added order. */
    public static final String GetAddedOrderID = "SELECT max(ord_id) from orders";

    /** SQL statement to add products to an order in the database. */
    public static final String AddOrderProduct = "INSERT INTO order_product " +
            "(op_product, op_order, op_amount) " +
            "VALUES " +
            "(?,?,?)";

    /**
     * Calculates the total price of an order based on the provided cart.
     * @param cart The list of items in the cart.
     * @return The calculated total order price.
     */
    public static float CalculateOrderPrice(List<CartItem> cart){
        float result = 0;
        for (CartItem cartItem : cart) {
            result += cartItem.getAmount()* Float.parseFloat(cartItem.getProduct().getPrice())*(100-cartItem.getProduct().getDiscount())/100;
        }
        return result;
    }
    /**
     * Creates an order with the provided address and cart items.
     * @param address The address for the order.
     * @param cart The list of items in the cart.
     * @throws DAOException if there's an error during order creation.
     */
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
    }
}
