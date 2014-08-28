package com.provisiontree.sqltorest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {

  public Connection getConnection() {
    loadDatabaseDriver();
    return createConnection();
  }

  private Connection createConnection() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(
          "jdbc:hsqldb:hsql://localhost/mytestdb", "sa", "");
    } catch (SQLException e) {
      System.out.println("ERROR: failed to connect to the databse");
      e.printStackTrace();
      con = null;
    }
    return con;
  }

  private void loadDatabaseDriver() {
    try {
      Class.forName("org.hsqldb.jdbcDriver");
    } catch (ClassNotFoundException cnfe) {
      System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
      cnfe.printStackTrace();
    }
  }
}
