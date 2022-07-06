package Dcp;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;




	public final class JdbcDataSource {
		
		private static JdbcDataSource jds =null;
		
		private ComboPooledDataSource ds = null;
		
		private JdbcDataSource() throws PropertyVetoException {
			ds = new ComboPooledDataSource();
			
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost/shubham");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(1);
			ds.setAcquireIncrement(1);
			ds.setMaxPoolSize(3);
		}
		
		public static JdbcDataSource getInstance() throws Exception {
			if(jds==null) {
				jds= new JdbcDataSource();
			}
			return jds;
		}
		
		public static Connection getConnection() throws Exception {
			return getInstance().ds.getConnection();
		}
//		public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
//			if(rs!=null) rs.close();
//			if(stmt!=null) stmt.close();
//			if(conn!=null) conn.close();
//		}
//		public static void closeConnection(Connection conn, Statement stmt) throws Exception {
//			closeConnection(conn,stmt,null);
//		}
//		public static void closeConnection(Connection conn) throws Exception {
//			closeConnection(conn,null,null);
//		}
//	

	}


