package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/cuahangtienloi";
		final String user = "root";
		final String password = "sang01102002";
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
	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		if(connection != null) {
			System.out.print("THANH CONG !");
		}else {
			System.out.print("THAT BAi !");
		}
	}
}