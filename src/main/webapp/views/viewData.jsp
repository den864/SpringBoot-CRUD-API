<%@page import="com.example.demo.courses.controller.CourseController"%>
<%@page import="com.example.demo.courses.repository.CourseRepository"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.example.demo.courses.bean.Course"%>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>

<%
	List<Course>l= (List<Course>) request.getAttribute("list");

%>

<body>
	
	<table border=1>
	<tr>
		<th>Id</th>
		<th>Course Name</th>
		<th>Author</th>
	</tr>
		<%
			for(Course c:l){
		%>
		<tr>
			<td><%= c.getId() %></td>
			<td><%= c.getName() %></td>		
			<td><%= c.getAuther() %></td>
		</tr>		
					
		<%} %>
	</table>
	
	<a href="/">To add</a>
	<a href="deletePage">To Delete</a>
	<a href="/editPage">To Update</a>
	
</body>
</html>