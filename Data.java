package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class Data extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String fname=req.getParameter("fname");
       String lname=req.getParameter("lname");
       String mnumber=req.getParameter("mnumber");
       Long no=Long.valueOf(mnumber);
       String uemail=req.getParameter("uemail");
       String address=req.getParameter("address");
       String anumber=req.getParameter("anumber");
       
       
       String Driver="com.mysql.cj.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/advjavae2?user=root&password=root";
       
       try {
		Class.forName(Driver);
		
		Connection connection = DriverManager.getConnection(url);
		
		String Query="INSERT INTO entery(FirstName,LastName,MobileNo,EmailId,Address,AadharNo)values(?,?,?,?,?,?)";
		
	    PreparedStatement stmt=connection.prepareStatement(Query);
	  
        stmt.setString(1, fname);
        stmt.setString(2, lname);	
        stmt.setLong(3, no);	
        stmt.setString(4, uemail);	
        stmt.setString(5, address);	
        stmt.setString(6, anumber);	
        
        int row=stmt.executeUpdate();
        PrintWriter w=resp.getWriter();
        if(row>0) {
        	w.println("Registration Sucefully ");
        	 resp.sendRedirect("Registation.html");
        }
        else {
        	
        	w.println("ENTER CORRECT DATA");
        	resp.sendRedirect("Registation.html");
        }
       
//        RequestDispatcher d=req.getRequestDispatcher("Registation.html");
//		d.include(req, resp);
        connection.close();
        
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
}
