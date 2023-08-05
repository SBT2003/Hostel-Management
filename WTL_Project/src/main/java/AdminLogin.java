

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminLoginDAO;
import DAO.LoginDAO;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		
		AdminLoginDAO logdb=new AdminLoginDAO();
		boolean verify=false;
		try {
			verify=logdb.check(uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(verify)
		{
			response.sendRedirect("Userdata.html");
			session.setAttribute("username", uname);
			session.setAttribute("isadmin", "yes");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
