package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MySQLConnect {
  ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/database");
  String database = "cuahangtienloi";
  String user = resourceBundle.getString("userName");
  String password = resourceBundle.getString("password");
 // String url = "jdbc:mysql://localhost:3310/" + database;
  String url = resourceBundle.getString("url");
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;

  public MySQLConnect() {
    super();
    // TODO Auto-generated constructor stub
  }

  public MySQLConnect(String database, String user, String password, String url) {
    super();
    this.database = database;
    this.user = user;
    this.password = password;
    this.url = url;
  }

  protected Connection OPconnect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connect successfully!");
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Connect failure!");
    }
    return connection;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public ResultSet getResultSet() {
    return resultSet;
  }

  public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
  }
}