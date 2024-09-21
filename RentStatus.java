package pro;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showstatus")
public class RentStatus extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 String Driver="com.mysql.cj.jdbc.Driver";
	 String user="root";
	 String password="root";
	 String url="jdbc:mysql://localhost:3306/advjavae2?";
	 
	 try {
		Class.forName(Driver);
		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		String Query="SELECT * FROM rent";
		
		Statement stmt=connection.createStatement();
		
		ResultSet rs=stmt.executeQuery(Query);
		
		List<Rent> rent=new ArrayList();
		
		PrintWriter w=resp.getWriter();
	  if(rs.isBeforeFirst()) {  
		while(rs.next()) {
			Rent r=new Rent(rs.getInt("StudentId"),rs.getString("Name"),rs.getString("LastName"),rs.getDouble("Deposit"),rs.getDouble("rent"));
			
			rent.add(r);	
		}
		req.setAttribute("Rent", rent);
		RequestDispatcher d=req.getRequestDispatcher("delet.jsp");
		d.include(req, resp);
		for(Rent r:rent) {
			w.println("<H1>"+r+"<hr></H1>");
		}	
	  }else {
		  w.println("Error");
	  }
	  
	  connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
}
	
}
