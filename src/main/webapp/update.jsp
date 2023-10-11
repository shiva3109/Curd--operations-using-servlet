<%@page import="com.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Employee e = (Employee) request.getAttribute("employee");
	%>
	<form action="edit">
		<label>ID :</label> <input type="number" name="id"
			placeholder="Enter the Id" value="<%=e.geteNo()%>"
			readonly="readonly"><br> <br> <label>Name :</label>
		<input type="text" name="name" placeholder="Enter the Name"
			value="<%=e.getName()%>"><br> <br> <label>Email
			:</label> <input type="email" name="email" placeholder="Enter the Email"
			value="<%=e.getEmail()%>" readonly="readonly"><br> <br>
		<label>Mobile :</label> <input type="tel" name="mobile"
			placeholder="Enter the MobileNo" value="<%=e.getMobileNo()%>"><br>
		<br> <label>Password :</label> <input type="text" name="password"
			placeholder="Enter the password" value="<%=e.getPassword()%>"><br>
		<br> <input type="submit" value="Update">
	</form>
</body>
</html>