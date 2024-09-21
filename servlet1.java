package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class servlet1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String useremail=req.getParameter("email");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/advjavae2?user=root&password=root");
			
			String q="SELECT * FROM verify WHERE Email=?";
			
			PreparedStatement pstmt=connection.prepareStatement(q);
			pstmt.setString(1,useremail);
			
			ResultSet rs=pstmt.executeQuery();
			PrintWriter w=resp.getWriter();
			resp.setContentType("text/html");
			
			if(rs.next()) {
				String Dbemail=rs.getString("Email");
				String Dbpassword=rs.getString("password");
				
				HttpSession s=req.getSession();
				s.setAttribute("Dbpassword",Dbpassword);
				
				
				w.println("<h1 style='color:red'>valid email</h1>");
				RequestDispatcher d=req.getRequestDispatcher("pverify.html");
				d.include(req, resp);
			}
			else {
				w.println("<h1 style='color:red'>Invalid email try again</h1>");
				RequestDispatcher d=req.getRequestDispatcher("everify.html");
				d.include(req, resp);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
