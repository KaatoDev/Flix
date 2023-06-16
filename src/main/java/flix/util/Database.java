package flix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String host = "localhost",
            porta = "3306",
            user = "root",
            pass = "anima123",
            database = "db_flix";
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://" + host + ":" + porta + "/" + database;
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
