

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out=response.getWriter();
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("emailid");
		String contact = request.getParameter("contact");
		String id = request.getParameter("collegeid");
		String add = request.getParameter("address");
		
		System.out.println(fname+lname+pwd+email+contact+id+add);
		
		RegisterDAO rd=new RegisterDAO();
		boolean b=false;
		try {
			b=rd.register_user(fname, lname, uname, pwd, email, contact, id, add);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		 if(b)
		 {
			 response.sendRedirect("Login.html");
		 }
		 else response.sendRedirect("index.html");
		 
	}

}












