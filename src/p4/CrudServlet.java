package p4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrudServlet
 */
@WebServlet("/CrudServlet")
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String s1=request.getParameter("fn");
		 String s2=request.getParameter("ln");
		 String s3=request.getParameter("un");
		 int s4=Integer.parseInt(request.getParameter("pwd"));
		 
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			 Statement st=c.createStatement();
			 st.executeUpdate("insert into login1(first_name,last_name,username,password)values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
			 PrintWriter out=response.getWriter();
	
			 ResultSet rs=st.executeQuery("Select * from login1");
			 out.write("<table border=1px>");
			 out.write("<th>FirstName</th>");
			 out.write("<th>lastName</th>");
			 out.write("<th>UsertName</th>");
			 out.write("<th>Password</th>");
			 while(rs.next())
			 {
				 String b1=rs.getString("first_name");
				 String b2=rs.getString("last_name");
				 String b3=rs.getString("username");
				 int b4=rs.getInt("password");
				 out.write("<tr>");
				 out.write("<td>");
				 out.write(b1);
				 out.write("</td>");
				 out.write("<td>");
				 out.write(b2);
				 out.write("</td>");
				 out.write("<td>");
				 out.write(b3);
				 out.write("</td>");
				 out.write("<td>");
				 out.write(b4);
				 out.write("</td>");
				 out.write("</tr>");
			 }
			 out.write("</table>");
			 st.close();
			 c.close();
		 }
		 catch(Exception e)
		 {
			 PrintWriter out=response.getWriter();
			 out.write("Error... In connection");
		 }
	}

}
