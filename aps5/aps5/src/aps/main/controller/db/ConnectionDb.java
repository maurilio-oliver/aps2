package aps.main.controller.config.db;

import java.sql.*;
import java.util.Collection;
import java.util.Properties;

public class ConnectionDb {
    private String url = "jdbc:postgresql://localhost:5433/test";
    private Connection connection;
    private Properties props = new Properties();




    private void openConnection() throws SQLException {
        this.props.setProperty("user", "postgres");
        this.props.setProperty("password", "postgres");
        this.props.setProperty("ssl", "false");

         try {connection = DriverManager.getConnection(url, props);}
            catch (Exception e) {e.printStackTrace();}
     }


    public ResultSet query(String query) throws SQLException {
        this.openConnection();
        Statement statement = connection.createStatement();

        return statement.executeQuery(query);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new ConnectionDb().query("select id, username from ta"));
    }
}
