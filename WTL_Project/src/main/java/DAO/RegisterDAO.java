package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	
	String sql="insert into user_data values(?,?,?,?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306/wtlProject";
	String usname="shrushti";
	String pw="shrushti@2003";
	
	public boolean register_user(String fname, String lname, String uname, String password, String email, String contact, String collegeid, String address) throws SQLException
	{
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,usname,pw);
	PreparedStatement st=con.prepareStatement(sql);
	st.setString(1, fname);
	st.setString(2, lname);
	st.setString(3, uname);
	st.setString(4, password);
	st.setString(5, email);
	st.setString(6, contact);
	st.setString(7, collegeid);
	st.setString(8, address);

	int i=st.executeUpdate();
	
	if(i>0)
	return true;
	}
	catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return false;
	

	}
}
