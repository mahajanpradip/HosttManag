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

@WebServlet("/rentpaid")
public class RentPaid extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  String Driver="com.mysql.cj.jdbc.Driver";
  String url="jdbc:mysql://localhost:3306/advjavae2?user=root&password=root";
  
  try {
	Class.forName(Driver);
	
	Connection connection=DriverManager.getConnection(url);
	
	String Query="SELECT * FROM rent WHERE (Rent=1800)";
	
	Statement stmt=connection.createStatement();
	
	ResultSet rs=stmt.executeQuery(Query);
	
	List<Rent> rent=new ArrayList();
	
	PrintWriter w=resp.getWriter();
	resp.setContentType("text/html");
	if(rs.isBeforeFirst()) {
		while(rs.next()) {
		Rent r=new Rent(rs.getInt("StudentId"),rs.getString("Name"),rs.getString("LastName"),rs.getDouble("Deposit"),rs.getDouble("rent"));
        rs.getInt("StudentId");
        rs.getString("Name");
		rent.add(r);
		
	}
		for(Rent r: rent) {
			w.println("<table><tr><th><H1>"+r+"<hr></H1><th/><tr/></table>");
		}
	}
	else {
		w.println("Error");
	}
	connection.close();
} catch (Exception e) {
	e.printStackTrace();
}
 
 }
	
}
