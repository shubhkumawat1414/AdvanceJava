package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestPSAdd {

	public static void main(String[] args) throws Exception {
		TestAdd();
	}

	private static void TestAdd() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham", "root", "root");
		
		PreparedStatement stmt = conn.prepareStatement("insert into marksheet value(16,116,'hulk','malfoy',98,12,12)");
		
		int rs = stmt.executeUpdate();
		
		System.out.println("rs+record(s)Added");

	}
}