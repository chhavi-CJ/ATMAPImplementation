package com.demo.atmAPI.db.connector;


import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionFactory {
  private static java.sql.Connection sqlConnection;

  public static java.sql.Connection getConnection() {
    //TODO pull from properties
    String driver = "org.h2.Driver";
    String dbName = "ATMModel";//jdbc:h2:tcp://localhost/~/test
    String dbURL = "jdbc:h2:tcp://localhost/~/" + dbName;
    String username = "sa";
    String password = "";

    if (sqlConnection != null) return sqlConnection;

    try {
      Class.forName(driver);
      sqlConnection = DriverManager.getConnection(dbURL, username, password);
      
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    return sqlConnection;
  }

  //TODO use it
  public static void closeConnection(java.sql.Connection sqlConnection) {
    try {
      sqlConnection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
