package in.co.rays.user;                        //Tuesday_10-10-023//

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	public Integer nextPk() throws Exception{
		
		int pk = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
		PreparedStatement ps = conn.prepareStatement("select max(id) from user");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			pk = rs.getInt(1);
			
		}
		
		return pk + 1;
		
	}
	                // add 
	
	public void add(UserBean bean)throws Exception{
		
	
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
     PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
     
     ps.setInt(1,nextPk());
     ps.setString(2,bean.getFirstName());
     ps.setString(3,bean.getLastName());
     ps.setString(4,bean.getLoginId());
     ps.setString(5,bean.getPassword());
     ps.setDate(6,new java.sql.Date(bean.getDob().getTime()));
     ps.setString(7,bean.getAddress());
     
     int i = ps.executeUpdate();
     System.out.println("Data inserted = " + i);
     
     
     
	}
	



          //Update

public void update(UserBean bean) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
	PreparedStatement ps = conn.prepareStatement("update user set first_name = ?,last_name = ?,login_id = ?,password = ?,dob = ?,address = ? where id = ?");
	
	ps.setString(1,bean.getFirstName());
    ps.setString(2,bean.getLastName());
    ps.setString(3,bean.getLoginId());
    ps.setString(4,bean.getPassword());
    ps.setDate(5,new java.sql.Date(bean.getDob().getTime()));
    ps.setString(6,bean.getAddress());
    ps.setInt(7,bean.getId());
    
    int i = ps.executeUpdate();
    System.out.println("Data inserted + i");
   }

          // delete

public void delete(int id) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
	PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
	

    ps.setInt(1, id);
    
    int i = ps.executeUpdate();
    System.out.println("Data Deleted" + i);
  }

                         //List Search

    public List search(UserBean bean,int pageNo,int pageSize)throws Exception {
		
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
    	StringBuffer sql = new StringBuffer("select * from user where 1=1");
    	
    	if(bean != null) {
    		if(bean.getFirstName()!= null && bean.getFirstName().length()>0) {
    		sql.append("and first_name like'" +bean.getFirstName()+ "%'");
    		}
    	
    	if(bean.getDob()!= null && bean.getDob().getTime()>0);{
    		sql.append("and dob like'"+ new java.sql.Date(bean.getDob().getTime())+ "%'");
    	}
 }
        if(pageSize > 0) {
        	pageNo = (pageNo-1) * pageSize;
        	sql.append("limit " + pageNo + "," + pageSize);
        }
        PreparedStatement ps = conn.prepareStatement(sql.toString());
        ResultSet rs = ps.executeQuery();
        List list = new ArrayList();
        
        while(rs.next())
    	
    	
		
    	
    
    
		return list;
		return list;

}
}
