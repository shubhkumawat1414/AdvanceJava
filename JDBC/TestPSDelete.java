package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestPSDelete {
	
	public static void main(String[] args) throws Exception {
		testdelete();
	}

	private static void testdelete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham", "root", "root");
		
		PreparedStatement stmt = conn.prepareStatement("delete from marksheet where id=16");
		
		int rs = stmt.executeUpdate();
		
		System.out.println(rs + "record deleted");

	}
}