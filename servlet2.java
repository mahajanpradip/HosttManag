package pro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userpassword=req.getParameter("Password");
		
		HttpSession s=req.getSession();
		String Password=(String)s.getAttribute("Dbpassword");
		
		PrintWriter w=resp.getWriter();
		resp.setContentType("text/html");
		
		if(userpassword.equals(Password)) {
			
			w.println("<h1 style='color:red'>Login sucessful</h1>");
			RequestDispatcher d=req.getRequestDispatcher("home.html");
			d.include(req, resp);
			
		}else {
			w.println("<h1 style='color:red'>Invalid password try again</h1>");
			RequestDispatcher d=req.getRequestDispatcher("everify.html");
			d.include(req, resp);
		}
		
	}
	
}
