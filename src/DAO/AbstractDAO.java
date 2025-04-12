package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import mapper.RowMapper;

public abstract class AbstractDAO<T> {



  public  Connection getConnection() {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/database");
    final String url = resourceBundle.getString("url");
    final String user = resourceBundle.getString("userName");
    final String password = resourceBundle.getString("password");
    try {
      Class.forName("com.mysql.jdbc.Driver");
      try {
        return DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  void setParameters(PreparedStatement preparedStatement, Object... parameters) {
    try {
      Object parameter;
      for (int i = 0; i < parameters.length; i++) {
        //do trong preparedStatement set từ 1 nên phải tăng index
        int index = i + 1;
        parameter = parameters[i];
        if (parameter instanceof Long) {
          preparedStatement.setLong(index, (Long) parameter);
        } else if (parameter instanceof String) {
          preparedStatement.setString(index, (String) parameter);
        } else if (parameter instanceof Integer) {
          preparedStatement.setInt(index, (Integer) parameter);
        } else if (parameter instanceof Float) {
          preparedStatement.setFloat(index, (Float) parameter);
        } else if (parameter instanceof Date) {
          preparedStatement.setDate(index, (java.sql.Date) parameter);
        } else if (parameter == null) {
          preparedStatement.setNull(index, Types.NULL);
        } else if (parameter instanceof StringBuilder) {
          preparedStatement.setString(index, (String) parameter.toString());
        } else if (parameter instanceof Double) {
          preparedStatement.setDouble(index, (Double) parameter);
        }
      }
    } catch (Exception e) {
      System.out.println("Lỗi không set được Parameters: " + e.getMessage());
    }
  }

  <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
    List<T> resultList = new ArrayList<T>();
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      setParameters(preparedStatement, parameters);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        resultList.add(rowMapper.mapRow(resultSet));
      }
      return resultList;
    } catch (SQLException throwables) {
      System.out.println("Lỗi ở query Abstract DAO: " + throwables.getMessage());
      return null;
    } finally {
      try {
        connection.close();
        resultSet.close();
        preparedStatement.close();
      } catch (Exception e) {
        return null;
      }
    }
  }

  void update(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = getConnection();
      preparedStatement = connection.prepareStatement(sql);
      connection.setAutoCommit(false);
      setParameters(preparedStatement, parameters);
      preparedStatement.executeUpdate();
      connection.commit();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ie) {
        System.out.println("Lỗi ở update AbstractDAO" + ie.getMessage());
      }
      System.out.println("Lỗi ở update AbstractDAO" + e.getMessage());
    } finally {
      try {
        connection.close();
        preparedStatement.close();
      } catch (SQLException e2) {
      }
    }
  }

  void insert(String sql, Object... parameters) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String ma = null;
    try {
      connection = getConnection();
      //do masanpham tự lập không phải hệ thống tự tạo nên không xài được
      //preparedStatement = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
      preparedStatement = connection.prepareStatement(sql);
      connection.setAutoCommit(false);
      setParameters(preparedStatement, parameters);
      preparedStatement.executeUpdate();
      connection.commit(); // commit luôn để cuối cùng
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ie) {
        System.out.println("Lỗi ở update AbstractDAO" + ie.getMessage());
      }
      System.out.println("Lỗi ở update AbstractDAO" + e.getMessage());
    } finally {
      try {
        connection.close();
        preparedStatement.close();
      } catch (SQLException e2) {
      }
    }
  }

  void save(String table, String[] fields, Object... parameters) {  //check
    StringBuilder stringBuilder = new StringBuilder(
        "INSERT INTO `cuahangtienloi`.");
    stringBuilder.append(table);
//    Field[] fields = object.getClass().getDeclaredFields();
    stringBuilder.append(" (");
    StringBuilder stringBuilder1 = new StringBuilder();
    for (String field : fields) {
      stringBuilder1.append(field + ",");
    }
    stringBuilder.append(stringBuilder1);
//    for (Field field : fields) {
//      stringBuilder.append(" ?,");
//    }
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    stringBuilder.append(")");
    stringBuilder.append(" VALUES (");
//    for (Field field : fields) {
//      stringBuilder.append("?,");
//    }\
    for (String field : fields) {
      stringBuilder.append("?,");
    }
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    stringBuilder.append(")");
//    stringBuilder.append(
//        " (MaChuongTrinh, MaSanPham, `%Giam`)");
//    stringBuilder.append(
//        " VALUES (?, ?, ?);");
    //insert(stringBuilder.toString(), table, parameters);
    insert(stringBuilder.toString(), parameters);
  }

  List<T> findAll(String table, RowMapper<T> rowMapper) { //check
    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    return query(sql.toString(), rowMapper);
  }

  T findOne(String table, String column, String data, RowMapper<T> rowMapper) { //check
    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    sql.append(" WHERE " + column + " = ?");
    List<T> resultList = query(sql.toString(), rowMapper, data);
    return resultList.isEmpty() ? null : resultList.get(0);
  }

  T findOne(String table, String column, String data, RowMapper<T> rowMapper, String column2,
      String data2) { //check
    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    sql.append(" WHERE " + column + " = ?");
    sql.append(" AND " + column2 + " = ?");
    List<T> resultList = query(sql.toString(), rowMapper, data, data2);
    return resultList.isEmpty() ? null : resultList.get(0);
  }

  List<T> findAllByCondition(String table, String column, String data,
      RowMapper<T> rowMapper) {
    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    sql.append(" WHERE " + column + " = ?");
    return query(sql.toString(), rowMapper, data);
  }

  List<T> findAllByConditions(String table, String[] condition,
      RowMapper<T> rowMapper, Object... parameters) {
    StringBuilder sql = new StringBuilder("SELECT * FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    sql.append(" WHERE ");
    for (int i = 0; i < condition.length; i++) {
      if (i == 0) {
        // trường hợp chỉ có 1 condition
        sql.append(condition[i] + " = ?;");
        sql.deleteCharAt(sql.length() - 1);
      } else {
        sql.append(" AND " + condition[i] + " = ?");
      }
    }
    return query(sql.toString(), rowMapper, parameters);

  }

  void update(String table, String[] fields, String[] condition, Object... parameters) {
    StringBuilder stringBuilder = new StringBuilder(
        "UPDATE  `cuahangtienloi`.");
    stringBuilder.append(table);
    stringBuilder.append(" SET ");
    StringBuilder stringBuilder1 = new StringBuilder();
    for (String field : fields) {
      stringBuilder1.append(field + " = ?,");
    }
    stringBuilder.append(stringBuilder1);
    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    stringBuilder.append(" WHERE ");
    for (int i = 0; i < condition.length; i++) {
      if (i == 0) {
        stringBuilder.append(condition[i] + " = ?;");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      } else {
        stringBuilder.append(" AND " + condition[i] + " = ?");
      }
    }
    update(stringBuilder.toString(), parameters);
  }

  void delete(String table, String[] condition, Object... parameters) {
    StringBuilder sql = new StringBuilder("DELETE FROM `cuahangtienloi`.");
    sql.append("`" + table + "`");
    sql.append(" WHERE ");
    for (int i = 0; i < condition.length; i++) {
      if (i == 0) {
        // trường hợp chỉ có 1 condition
        sql.append(condition[i] + " = ?;");
        sql.deleteCharAt(sql.length() - 1);
      } else {
        sql.append(" AND " + condition[i] + " = ?");
      }
    }
    update(sql.toString(), parameters);
  }

  List<T> findWithLike(String table, String field, RowMapper<T> rowMapper, String data) {
    StringBuilder sql = new StringBuilder(
        "SELECT * FROM `cuahangtienloi`.`" + table + "` WHERE " + field + " LIKE ?");
    return query(sql.toString(), rowMapper, data);
  }
}