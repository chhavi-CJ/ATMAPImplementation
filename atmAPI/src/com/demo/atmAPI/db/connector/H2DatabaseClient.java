package com.demo.atmAPI.db.connector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2DatabaseClient {

  //TODO close the connection
  public ResultSet executeSelect(String query) {
    System.out.println("DatabaseClient.executeStatement start");

    ResultSet resultSet = null;
    try {
      Connection connection = H2ConnectionFactory.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return resultSet;
  }

  public PreparedStatement getPreparedStatement(String query) {
    PreparedStatement preparedStatement = null;
    try {
      Connection connection = H2ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement(query);

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return preparedStatement;
  }

  public int executeUpdate(String query) {
    System.out.println("DatabaseClient.executeStatement start");
    int count = 0;

    try {
      Connection connection = H2ConnectionFactory.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      count = preparedStatement.executeUpdate();

    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }

    return count;
  }
}
