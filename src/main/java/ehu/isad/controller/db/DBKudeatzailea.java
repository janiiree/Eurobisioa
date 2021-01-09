package ehu.isad.controller.db;

import java.io.InputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class DBKudeatzailea {

    Connection conn = null;

    private static final DBKudeatzailea instance = new DBKudeatzailea();

    public static DBKudeatzailea getInstance() {
        return instance;
    }

    private DBKudeatzailea() {
        Properties properties = null;
        InputStream in = null;

        try {
            in = this.getClass().getResourceAsStream("/setup.properties");
            properties = new Properties();
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.conOpen(properties.getProperty("dbpath"));
    }

    private void conOpen(String dbpath) {
        try {
            String url = "jdbc:sqlite:" + dbpath;
            conn = DriverManager.getConnection(url);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to the database server " + e);
        }
    }

    private void conClose() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Database connection terminated");
    }

    public ResultSet execSQL(String query) {
        int count;
        Statement s;
        ResultSet rs = null;

        try {
            s = conn.createStatement();
            if (query.toLowerCase().indexOf("select") == 0) {   //select aginduak
                rs = this.query(s, query);
            } else {    //update, delete, create aginduak
                count = s.executeUpdate(query);
                System.out.println(count + " rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private ResultSet query(Statement s, String query) {
        ResultSet rs = null;
        try {
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
