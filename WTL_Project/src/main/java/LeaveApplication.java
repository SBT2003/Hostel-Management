

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LeaveApplyDAO;


@WebServlet("/LeaveApplication")
public class LeaveApplication extends HttpServlet {
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String inDate=request.getParameter("inDate");
		String exitDate=request.getParameter("exitDate");
		String roomno=request.getParameter("roomno");
		
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");
		
		if(uname==null)
		{
			response.sendRedirect("Login.jsp");
		}
		else {
		LeaveApplyDAO l=new LeaveApplyDAO();
		boolean b=false;
		
		try {
			b=l.inserted(address, contact,inDate, exitDate,roomno,uname,"pending");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(b)
		{
			response.sendRedirect("index.html");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
		}
		
	}

}
