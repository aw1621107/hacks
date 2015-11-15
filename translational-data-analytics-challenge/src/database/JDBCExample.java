package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/";

	private static final String USER = "root";
	private static final String PASS = "";

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			  Statement stmt = conn.createStatement()){

		} catch(SQLException se) {
			se.printStackTrace();
		}
	}
}