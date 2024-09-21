<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="pro.Rent"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</html>

<%List<Rent> rent1=(List<Rent>)request.getAttribute("Rent");
%>


<h1>update book details</h1>

<form action="Delet">
<input name="" value=<%=b1.getId() %> readonly>
<label for="bookname" id="bname"> book name</label>
<input type="text" value="<%= b1.getName() %>" name="bookname" id="bname" >
<br>
<label for="bookname" id="bp">book price</label>
<input type="text" value="<%= b1.getPrice() %>" name="bookprice" id="bp">
<br>
<label for="pages" id="pages">pages</label>
<input type="number" value="<%= b1.getPages() %>" name="pages" id="pages">
<br>
<input type="submit" value="update">

</form>
</body>
</html>