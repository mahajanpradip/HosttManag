package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/renttodatabase")
public class RentToData extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Id=req.getParameter("id");
		  int id=Integer.parseInt(Id);
		String Name=req.getParameter("name");
		String LastName=req.getParameter("lastname");
		String Deposit=req.getParameter("deposit");
		double Deposite=Double.parseDouble(Deposit);
		String rent=req.getParameter("rent");
		double Rent=Double.parseDouble(rent);
		
		String Driver="com.mysql.cj.jdbc.Driver";
		String user="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/advjavae2?";
		
		try {
			Class.forName(Driver);
			Connection connection=DriverManager.getConnection(url,user,password);
			
			String Query="INSERT INTO rent(StudentId,Name,LastName,Deposit,Rent)values(?,?,?,?,?)";
			
			PreparedStatement pstmt=connection.prepareStatement(Query);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, Name);
			pstmt.setString(3, LastName);
			pstmt.setDouble(4, Deposite);
			pstmt.setDouble(5, Rent);
			
			int rs=pstmt.executeUpdate();
			PrintWriter w=resp.getWriter();
			if(rs>0) {
				w.println("DATA ADDED SUCCESSFULL");
			}else {
				w.println("FAILD");
			}
			
			pstmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
