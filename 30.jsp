<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection c=DriverManager.getConnection("jdbc:mysql://database-1.cg9zxabxiaam.us-east-2.rds.amazonaws.com/demo","admin","admin1234");
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select * from form");

%>
<table border="1px solid black; height:500px;width:500px">
<tr>
<td><b>Id</b></td>
<td><b>FirstName</b></td>
<td><b>LastName</b></td>
<td><b>Address</b></td>
<td><b>Gender</b></td>
<td><b>Hobby</b></td>
</tr>
<%

while(rs.next())
{
	int i=rs.getInt("id");
	String s1=rs.getString("first_name");
	String s2=rs.getString("last_name");
    String s3=rs.getString("address");
    String s4=rs.getString("gender");
    String s5=rs.getString("hobby");
%>
<tr>

<td><% out.println(i);%></td>
<td><% out.println(s1);%></td>
<td><% out.println(s2);%></td>
<td><% out.println(s3);%></td>
<td><% out.println(s4);%></td>
<td><% out.println(s5);%></td>
</tr>
<% 
}
%>
</table>
<% 
rs.close();
st.close();
c.close();

%>

</body>
</html>