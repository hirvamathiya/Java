<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<form action="First">
Search By Name:<input type="text" name="fn"><br><br>
<input type="Submit" value="Submit"><br><br>
<table border=1>
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Action</th>
</tr>
<c:forEach items="${sessionScope.st1}" var="i">
<tr>
<td>${i.id}</td>
<td>${i.firstname}</td>
<td>${i.lastname}</td>
<td><a href='First?flag=delete x=${i.id}'>Delete</a>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>