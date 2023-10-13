package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.Driver;

public class CrudTest {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/raystech","root","root");
		PreparedStatement ps = conn.prepareStatement("insert into emp values(10,'shubham',6500)");
		
	}

}
