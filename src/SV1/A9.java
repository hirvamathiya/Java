package SV1;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ADemo")
public class A9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public A9() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String a=request.getParameter("flag");
		if(a.equals("Search"))
		{
			Search(request,response);
		}
		else if(a.equals("Delete"))
		{
			
			Delete(request,response);
		}
		/*else if(a.equals("Edit"))
		{
			Edit(request,response);
		}*/
	}    
		
	protected void Search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	       {
		     PrintWriter out=response.getWriter();
		     try
		     {
		     Class.forName("com.mysql.jdbc.Driver");
		     Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
		     Statement st=c.createStatement();
		     ResultSet rs=st.executeQuery("select * from jdbc1");
		     out.write("<table border=1>");
		     out.write("<th>ID</th>");
		     out.write("<th>FirstName</th>");
		     out.write("<th>LastName</th>");
		     out.write("<th>Action</th>");
		     out.write("<th>Action</th>");
		     while(rs.next())
		     {
		    	 int a1=rs.getInt("id");
		    	 String a2=rs.getString("first_name");
		    	 String a3=rs.getString("last_name");
		    	 out.write("<tr>");
		    	 out.write("<td>"+a1+"</td>");
		    	 out.write("<td>"+a2+"</td>");
		    	 out.write("<td>"+a3+"</td>");
		    	 out.write("<td>" + "<a href='ADemo?flag=Edit x="+a1+"'> Edit</a>" + "</td>");
		    	 out.write("<td>" + "<a href='ADemo?flag=Delete y="+a1+"'> Delete</a>" + "</td>");
		    	 out.write("</tr>");
		     }
		     out.write("</table>");
		     st.close();
		     
		     }
		     catch(Exception e)
		     {
		    	 e.getMessage();
		     }
		   
	       }
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
	  
	  
	   try
	   {
		     Class.forName("com.mysql.jdbc.Driver");
		     Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
		     Statement st=c.createStatement();
		     st.executeUpdate("delete from jdbc1 where id=");
		     st.close();
		   
	   }
	   catch(Exception e)
	   {
		   e.getMessage();
	   }
	  
    }
	protected void Edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		String p1=request.getParameter("x");
		PrintWriter out=response.getWriter();
		out.write(p1);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		   String s=request.getParameter("flag");
		   if(s.equals("insert"))
		    {
			  
			 insert(request,response);
			    
	        }
		  
	}
	
	
   protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
       {
	     String s1=request.getParameter("fn");
	     String s2=request.getParameter("ln");
	     try
	     {
	     Class.forName("com.mysql.jdbc.Driver");
	     Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
	     Statement st=c.createStatement();
	     st.executeUpdate("insert into jdbc1(first_name,last_name) values('"+s1+"','"+s2+"')");
	     st.close();
	     response.sendRedirect("jdbc_crud.jsp");
	     }
	     catch(Exception e)
	     {
	    	 e.getMessage();
	     }
	   
	   }    
   }

