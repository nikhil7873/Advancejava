package in.co.rays.user;                        //Tuesday_10-10-023//

import java.text.SimpleDateFormat;

public class TestUser {
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		  testdelete();
	}
	  public static void testAdd() throws Exception{
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  UserBean bean = new UserBean();
		  
		  bean.setFirstName("Nikhil");
		  bean.setLastName("khandait");
		  bean.setLoginId("nikhilkhandait@gmail.com");
		  bean.setPassword("1001");
		  bean.setDob(sdf.parse("2001-08-10"));
		  bean.setAddress("indore");
		  
		  UserModel model = new UserModel();
		  model.add(bean);
	  }
	  public static void testUpdate() throws Exception{
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  UserBean bean = new UserBean();
		  
		  bean.setFirstName("akhil");
		  bean.setLastName("patel");
		  bean.setLoginId("sachinptl@gmail.com");
		  bean.setPassword("1235");
		  bean.setDob(sdf.parse("2001-08-10"));
		  bean.setAddress("indore");
		  bean.setId(1);
		  
	      UserModel model = new UserModel();
	       model.update(bean);
	  
	}
         public static void testdelete() throws Exception{
		  
		  UserModel model = new UserModel();
		  model.delete(1);
}
}
	 
 