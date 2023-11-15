package com.example.wt_laba2.pool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final int INITIAL_POOL_SIZE = 10;

    private List<Connection> connections;

    public ConnectionPool() {}

    public void CreateConnections() throws SQLException{
        connections = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                connections.add(connection);
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            // If no available connections, create a new one
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        // Get the first available connection from the pool
        return connections.remove(connections.size() - 1);
    }

    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }

    public void closeAllConnections() throws SQLException {
        for (Connection connection : connections) {
            connection.close();
        }
        connections.clear();
    }
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException{
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
    public static void closeStatement(Statement statement) throws SQLException{
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public static void commitQuery(Connection con) throws SQLException{
        try{
            con.commit();
        }catch (SQLException ex){
            throw  new SQLException(ex);
        }
    }

    public static void rollbackQuery(Connection con){
        try {
            con.rollback();
        }catch (SQLException ex){
            System.out.println("Rollback error");
        }
    }
}

