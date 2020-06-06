package com.alexmanwell.impvocabapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    final static Logger logger = LogManager.getLogger(ConnectionDataBase.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.debug("Failed find DataBase driver: {}", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/impvocabapp";
        return DriverManager.getConnection(url, "postgres", "");
    }
}
