package Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	public int nextpk() throws Exception {
		int pk =0;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		
		conn.setAutoCommit(false);
		
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet1");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		return pk+1;
	}
	
	public void testAdd(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.ResourceBundle.app");
		System.out.println(rb.getString("Driver"));
		
		
		Class.forName(rb.getString("Driver")).newInstance();
		
		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Insert into Marksheet1 values(?,?,?,?,?,?)");
		
		ps.setInt(1,nextpk());
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getName());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		
		ps.executeUpdate();
		conn.commit();
		
		conn.close();
		ps.close();
		
		
	}
	
	public void testUpdate(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("update mark set name=?,Physics=?,Chemistry=?,Maths=? where rollno=?");
		
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getPhysics());
		ps.setInt(3, bean.getChemistry());
		ps.setInt(4, bean.getMaths());
		ps.setString(5, bean.getRollno());
		
		ps.executeUpdate();
		conn.commit();
		
		conn.close();
		ps.close();
		
		
	}
	
	public void testDelete(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Delete From mark where Rollno=?");
		
		ps.setString(1, bean.getRollno());
		
		ps.executeUpdate();
		conn.commit();
		
		conn.close();
		ps.close();
	}
	
	public List<MarksheetBean> testGet(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select * From mark where rollno=?");
		
		ps.setString(1, bean.getRollno());
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		while (rs.next()) {
			
		MarksheetBean bean1 = new MarksheetBean();	
		
		bean1.setRollno(rs.getString(1));
		bean1.setName(rs.getString(2));
		bean1.setPhysics(rs.getInt(3));
		bean1.setChemistry(rs.getInt(4));
		bean1.setMaths(rs.getInt(5));
		list.add(bean1);
		
		}
		return list;
}
	
	public List<MarksheetBean> search() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shubham", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select * from Mark");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			
			bean1.setRollno(rs.getString(1));
			bean1.setName(rs.getString(2));
			bean1.setPhysics(rs.getInt(3));
			bean1.setChemistry(rs.getInt(4));
			bean1.setMaths(rs.getInt(5));
			list.add(bean1);
		}
		return list;
	}

	public List<MarksheetBean> getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/shubham", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select *, ((physics + chemistry + maths)/3) as percentage from Mark where (physics > 40 AND chemistry > 40 AND Maths > 40) order by (physics + chemistry + maths) desc");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			
			bean1.setRollno(rs.getString(1));
			bean1.setName(rs.getString(2));
			bean1.setPhysics(rs.getInt(3));
			bean1.setChemistry(rs.getInt(4));
			bean1.setMaths(rs.getInt(5));
			list.add(bean1);
		}
		return list;
	}
}