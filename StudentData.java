package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentdata")
public class StudentData extends HttpServlet{
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  String Driver="com.mysql.cj.jdbc.Driver";
	  String user="root";
	  String password="root";
	  String url="jdbc:mysql://localhost:3306/advjavae2?";
	  
	  try {
		Class.forName(Driver);
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		String Query="SELECT * FROM entery";
		
	    Statement stmt=connection.createStatement();
	    
	    List<Students> students=new ArrayList();
	    
	    ResultSet rs=stmt.executeQuery(Query);
	    PrintWriter w=resp.getWriter();
	    resp.setContentType("text/html");
	    if(rs.isBeforeFirst()) {
	    while(rs.next()) {
	    	Students s=new Students();
	    	s.setFirstName(rs.getString("FirstName"));
	    	s.setLastName(rs.getString("LastName"));
	    	s.setMobileNo(rs.getLong("MobileNo"));
	    	s.setEmailId(rs.getString("EmailId"));
	    	s.setAddress(rs.getString("Address"));
	    	s.setAadharNo(rs.getLong("AadharNo"));

	         students.add(s);
	 
	    	}
	    for(Students s1:students) {
	    	w.println("<hr>");
	    	w.println("<table>");
    		w.println("<tr><th>Firstname</th><td>"+s1.getFirstName()+"</td></tr>");
    		w.println("<tr><th>LastName</th><td>"+s1.getLastName()+"</td></tr>");
    		w.println("<tr><th>MobileNo</th><td>"+s1.getMobileNo()+"</td></tr>");
    		w.println("<tr><th>EmailId</th><td>"+s1.getEmailId()+"</td></tr>");
    		w.println("<tr><th>Address</th><td>"+s1.getAddress()+"</td></tr>");
    		w.println("<tr><th>AadharNo</th><td>"+s1.getAadharNo()+"</td></tr>");
    		w.println("</table>");
    		w.println("<hr>");
    	
	    }
	    }
	    else {
	    	w.println("NO DATA FOUND TRY AFTER SOME TIME!!!!");
	    }
	    
	    stmt.close();
	    rs.close();
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
