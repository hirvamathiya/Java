package controller;
import DAO.*;
import java.util.*;
import VO.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String s1=request.getParameter("fn");
		/*String s2=request.getParameter("flag");
		Integer p=Integer.parseInt(request.getParameter("x"));
		if(s2.equals("delete"))
		{
			Regi_Vo re=new Regi_Vo();
			re.setId(p);
			
			Regi_Dao d1=new Regi_Dao();
			d1.delete(re);
		}*/
		Regi_Vo v1=new Regi_Vo();
		v1.setFirstname(s1);
	
		Regi_Dao d=new Regi_Dao();
		
		try
		{
		
		List<Regi_Vo> ls=(d.search(v1));		
		HttpSession session=request.getSession();
		session.setAttribute("st1", ls);
		response.sendRedirect("First.jsp");
        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
    	}

}
