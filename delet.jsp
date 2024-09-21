
<%@page import="pro.Rent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
border:2px solid black;
}
td{
	border:2px solid black;
	}
</style>
</head>
<body>
<h1>ALL RENT STATUS</h1>
<% //fetch the data 
  //List<book> books= //(List)request.getAttribute("viewbooks");
 List<Rent> rent=(List<Rent>)request.getAttribute("Rent");


%>
<table>
		<tr>
		<td>StudentId</td>
		<td>Name</td>
		<td>LastName</td>
		<td>Deposit</td>
		<td>rent</td>
		</tr>
<%
	for(Rent r1:rent){
%>
<tr>
	<td><%= r1.getStudentId() %></td>
	<td><%= r1.getName() %></td>
	<td><%= r1.getLastName() %></td>
	<td><%= r1.getDeposit() %></td>
	<td><%= r1.getRent() %></td>
	<td>
	<a href="deleteRent?StudentId=<%=r1.getStudentId()%>"> <button>Delete</button></a>
	<a href="updateRent?StudentId=<%=r1.getStudentId() %>"><button>Update</button></a>
	</td>
</tr>

<% }
%>
 <tr>
              <td colspan="6">r1</td>
                </tr>


</table>

</body>
</html>

</body>
</html>