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
<form action="Second?flag=update" method="post">
<c:forEach items="${sessionScope.st3}" var="j">
FirstName:<input type="text" name="first" value="${j.firstname}"><br><br>
LastName:<input type="text" name="last" value="${j.lastname}"><br><br>
<input type="hidden" name="z" value="${j.id}">
<input type="Submit" value="update">
</c:forEach>
</form>
</body>
</html>