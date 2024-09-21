package pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rentupdate")
public class RentUpdate extends HttpServlet{

//	  @Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		  String Driver="com.mysql.cj.jdbc.Driver";
//		  String User="root";
//		  String password="root";
//		  String url="jdbc:mysql://localhost:3306/advjavae2?";
//		  
//		  try {
//			Class.forName(Driver);
//			
//			Connection connection=DriverManager.getConnection(url,User,password);
//			
//			String Query="DELET * FROM rent WHERE StudentId=?";
//			
//			PreparedStatement pstmt=connection.prepareStatement(Query);
//			
//			List<Rent> rent=new ArrayList();
//			
//			ResultSet rs=pstmt.executeQuery();
//			
//			PrintWriter w=resp.getWriter();
//			
//			if(rs.next()) {
//				Rent r=new Rent(rs.getInt("StudentId"),rs.getString("Name"),rs.getString("LastName"),rs.getDouble("Deposit"),rs.getDouble("rent"));
//				
//				rent.add(r);
//			}else {
//				
//				w.println("NO DATA FOUND");
//			}
//			
//			rs.close();
//			pstmt.close();
//			connection.close();
			
			// Fetch form data
//	        int id = Integer.parseInt(req.getParameter("bookId"));
//	        String name = req.getParameter("name");
//	        int pages = Integer.parseInt(req.getParameter("pages"));
//	        double price = Double.parseDouble(req.getParameter("price"));
//
//	        String url = "jdbc:mysql://localhost:3307/advancejavae2?user=root&password=sql123";
//	        String query = "UPDATE book SET book_name = ?, pages = ?, price = ? WHERE book_id = ?";
//	        String Driver = "com.mysql.cj.jdbc.Driver";
//	        
//	        try {
//	            Class.forName(Driver);
//	            Connection connection = DriverManager.getConnection(url);
//	            PreparedStatement pstmt = connection.prepareStatement(query);
//	            pstmt.setString(1, name);
//	            pstmt.setInt(2, pages);
//	            pstmt.setDouble(3, price);
//	            pstmt.setInt(4, id);
//	            int noOfRecords = pstmt.executeUpdate();
//	            
//	            if (noOfRecords != 0) {
//					//display ViewAllBooks.jsp
//					RequestDispatcher dispatcher = req.getRequestDispatcher("viewbooks");
//					dispatcher.include(req, resp);
//				} 
//				else {
//					//display index.jsp
//					PrintWriter writer = resp.getWriter();
//					resp.setContentType("text/html");
//					writer.println("<center><h1>NO RECORDS FOUND WITH ID : " + id + "</h1></center>");
//					RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//					dispatcher.include(req, resp);
//				}
//	        } 
//	        catch (Exception e) 
//	        {
//	            e.printStackTrace();
//	            resp.getWriter().write("Error: " + e.getMessage());
//	        }
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//fetch the record
				int id = Integer.parseInt(req.getParameter("Bookid"));
				
				//to delete data from db
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/advjavae2?user=root&password=root";
					String query="Delete from book where bookid=?";
					Connection connection = DriverManager.getConnection(url);
					PreparedStatement pstmt=connection.prepareStatement(query);
					pstmt.setInt(1, id);
					int no_of_records=pstmt.executeUpdate();
					if(no_of_records !=0) {
						//display viewallbook.jsp
						RequestDispatcher dispatcher=req.getRequestDispatcher("RentStatus");
						dispatcher.include(req, resp);
						
					}
					else {
						PrintWriter writer=resp.getWriter();
						resp.setContentType("text/html");
						writer.println("<center><h1>No record found with id:</h1></center> " +id);
						RequestDispatcher dispatcher=req.getRequestDispatcher("index1.jsp");
						dispatcher.include(req, resp);
						
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
	}
	
