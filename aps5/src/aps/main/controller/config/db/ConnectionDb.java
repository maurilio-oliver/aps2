package aps.main.controller.config.db;

import java.sql.*;
import java.util.Collection;
import java.util.Properties;

public class ConnectionDb {
    private String url = "jdbc:postgresql://localhost:5433/test";
    private Connection connection;
    private Properties props = new Properties();

    public ConnectionDb(){



    }
    private void openConnection() throws SQLException {
        this.props.setProperty("user", "postgres");
        this.props.setProperty("password", "postgres");
        this.props.setProperty("ssl", "false");
         try {connection = DriverManager.getConnection(url, props);}
            catch (Exception e) {e.printStackTrace();}
     }


    public PreparedStatement getPrepareStatement(String query) throws SQLException {
        this.openConnection();
        return connection.prepareStatement(query);
    }


    public void close() throws SQLException {
    connection.close();
    }



}
