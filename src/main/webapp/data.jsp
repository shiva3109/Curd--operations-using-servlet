<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
	<table border="2px solid">
		<tr>
			<th>ENO</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>MOBILE</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>
		<%
		List<Employee> emp = (List<Employee>) request.getAttribute("list");
		%>
		<%
		for (Employee e : emp) {
		%>
		<tr>
			<td><%=e.geteNo()%></td>
			<td><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getMobileNo()%></td>
			<td><a href="delete?id=<%= e.geteNo()%>">Delete</a></td>
			<td><a href="update?id=<%= e.geteNo()%>">update</a></td>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>