package com.example.wt_laba2.pool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a pool of database connections.
 */
public class ConnectionPool {

    // Constants defining database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final int INITIAL_POOL_SIZE = 10;

    private List<Connection> connections;

    /**
     * Constructs a ConnectionPool object.
     */
    public ConnectionPool() {}

    /**
     * Creates database connections and initializes the pool.
     * @throws SQLException if an SQL error occurs during connection creation.
     */
    public void CreateConnections() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
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

    /**
     * Retrieves a connection from the pool.
     * @return a database connection.
     * @throws SQLException if an SQL error occurs during connection retrieval.
     */
    public synchronized Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            // If no available connections, create a new one
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        // Get the first available connection from the pool
        return connections.remove(connections.size() - 1);
    }

    /**
     * Releases a connection back to the pool.
     * @param connection The connection to release.
     */
    public synchronized void releaseConnection(Connection connection) {
        connections.add(connection);
    }

    /**
     * Closes all connections in the pool.
     * @throws SQLException if an SQL error occurs while closing connections.
     */
    public void closeAllConnections() throws SQLException {
        for (Connection connection : connections) {
            connection.close();
        }
        connections.clear();
    }

    /**
     * Closes a PreparedStatement if it's not null and not closed already.
     * @param preparedStatement The PreparedStatement to close.
     * @throws SQLException if an SQL error occurs while closing the PreparedStatement.
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * Closes a Statement if it's not null and not closed already.
     * @param statement The Statement to close.
     * @throws SQLException if an SQL error occurs while closing the Statement.
     */
    public static void closeStatement(Statement statement) throws SQLException {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


    /**
     * Closes a ResultSet if it's not null and not closed already.
     * @param resultSet The ResultSet to close.
     * @throws SQLException if an SQL error occurs while closing the ResultSet.
     */
    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


    /**
     * Commits a transaction in the given Connection.
     * @param con The Connection to commit the transaction for.
     * @throws SQLException if an SQL error occurs while committing the transaction.
     */
    public static void commitQuery(Connection con) throws SQLException {
        try {
            con.commit();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }


    /**
     * Rolls back a transaction in the given Connection.
     * @param con The Connection to roll back the transaction for.
     */
    public static void rollbackQuery(Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex) {
            System.out.println("Rollback error");
        }
    }

}

