package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	String sql="select * from user_data where uname=? and password=?";
	String url="jdbc:mysql://localhost:3306/wtlProject";
	String usname="shrushti";
	String pw="shrushti@2003";
	public boolean check(String uname, String password) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,usname,pw);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, password);
			ResultSet rs=st.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
}
