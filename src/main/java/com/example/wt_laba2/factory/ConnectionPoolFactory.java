package com.example.wt_laba2.factory;

import com.example.wt_laba2.pool.ConnectionPool;

/**
 * Factory class responsible for providing a single instance of the ConnectionPool.
 */
public class ConnectionPoolFactory {

    private final static ConnectionPoolFactory factory = new ConnectionPoolFactory();

    // The instance of ConnectionPool created by the factory
    private final ConnectionPool connectionPool = new ConnectionPool();

    /**
     * Private constructor to prevent direct instantiation from outside the class.
     */
    private ConnectionPoolFactory() {
        // Initialization of the factory
    }

    /**
     * Returns the singleton instance of the ConnectionPoolFactory.
     * @return The instance of ConnectionPoolFactory.
     */
    public static ConnectionPoolFactory getInstance(){
        return factory;
    }

    /**
     * Retrieves the instance of the ConnectionPool created by the factory.
     * @return The instance of ConnectionPool.
     */
    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
