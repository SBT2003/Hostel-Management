

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		
		LoginDAO logdb=new LoginDAO();
		boolean verify=false;
		try {
			verify=logdb.check(uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(verify)
		{
			response.sendRedirect("NewIndex.html");
			session.setAttribute("username", uname);
		}
		else {
			response.sendRedirect("Login.html");
		}
	}

}
