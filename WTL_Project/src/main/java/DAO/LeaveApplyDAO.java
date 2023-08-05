package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveApplyDAO {
	String sql="insert into leaveApplications values(?,?,?,?,?,?,?)";
	String url="jdbc:mysql://localhost:3306/wtlProject";
	String usname="shrushti";
	String pw="shrushti@2003";
	
	
	public boolean inserted(String address, String contact, String inDate, String exitDate, String roomno, String uname, String Status) throws SQLException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,usname,pw);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, address);
			st.setString(2, contact);
			st.setString(3, inDate);
			st.setString(4, exitDate);
			st.setString(5, roomno);
			st.setString(6, uname);
			st.setString(7, Status);
			
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
