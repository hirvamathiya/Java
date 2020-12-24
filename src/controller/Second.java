package controller;
import VO.*;
import DAO.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Second() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String s=request.getParameter("flag");
		
		
		if(s.equals("search"))
		{
			Regi_Dao da2=new Regi_Dao();
	
			try
			{
			
			List<Regi_Vo> ls=(da2.search());		
			HttpSession session=request.getSession();
			session.setAttribute("st2", ls);
			response.sendRedirect("Search.jsp");
	        
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
	    	
		}	
		
	    if(s.equals("delete"))
		{
		
			int a=Integer.parseInt(request.getParameter("x"));
		
			Regi_Vo re=new Regi_Vo();
			re.setId(a);
			
			Regi_Dao d1=new Regi_Dao();
			d1.delete(re);
			response.sendRedirect("Search.jsp");
		}
	    
	    if(s.equals("edit"))
	    {
	    	
	    	int b=Integer.parseInt(request.getParameter("y"));
	    	
	    	Regi_Vo re1=new Regi_Vo();
	    	re1.setId(b);
	    	
	    	Regi_Dao d2=new Regi_Dao();
	    	try
	    	{
	    		
	    	List<Regi_Vo> ls2=(d2.edit(re1));
	    	HttpSession session=request.getSession();
			session.setAttribute("st3", ls2);
 			response.sendRedirect("edit.jsp");
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	
	    }
	    
	    
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String s=request.getParameter("flag");
		
		if(s.equals("add"))
		{
		
		String st=request.getParameter("fn");
		String st1=request.getParameter("ln");
		
		Regi_Vo r=new Regi_Vo();
    	r.setFirstname(st);
		r.setLastname(st1);
		
		Regi_Dao da1=new Regi_Dao();
		da1.insert(r);
		response.sendRedirect("Second.jsp");
		}
		
		else if(s.equals("update"))
		{
			try
			{
			
				int str2=Integer.parseInt(request.getParameter("z"));
		    	String str=request.getParameter("first");
		    	String str1=request.getParameter("last");
		    	
		    	Regi_Vo re2=new Regi_Vo();
		    	re2.setId(str2);
		    	re2.setFirstname(str);
		    	re2.setLastname(str1);
		    	
		    	Regi_Dao d3=new Regi_Dao();
		    	d3.update(re2);
		    	response.sendRedirect("Search.jsp");
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
			
		
	}

}
