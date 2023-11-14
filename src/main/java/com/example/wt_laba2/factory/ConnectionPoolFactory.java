package com.example.wt_laba2.factory;

import com.example.wt_laba2.pool.ConnectionPool;

public class ConnectionPoolFactory {

    private final static ConnectionPoolFactory factory = new ConnectionPoolFactory();

    private final ConnectionPool connectionPool = new ConnectionPool();

    public static ConnectionPoolFactory getInstance(){
        return factory;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
