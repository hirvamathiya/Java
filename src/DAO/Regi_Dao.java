package DAO;
import VO.*;
import java.sql.*;
import java.util.*;
public class Regi_Dao
{

	public void insert(Regi_Vo r)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			Statement st=c.createStatement();
			st.executeUpdate("insert into jdbc1(first_name,last_name) values('"+r.getFirstname()+"','"+r.getLastname()+"')");
			st.close();
			c.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 }
	public void delete(Regi_Vo re)
	{
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
		Statement st=c.createStatement();
		st.executeUpdate("delete from jdbc1 where id='"+re.getId()+"'");
		st.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public  List<Regi_Vo> edit(Regi_Vo re1)
	{
		
		try
		{
			ArrayList<Regi_Vo> l1 = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from jdbc1 where id='"+re1.getId()+"'");
			while(rs.next())
			{
				

				Regi_Vo v3= new Regi_Vo();
				int id=rs.getInt("id");
				String f2=rs.getString("first_name");
				String l2=rs.getString("last_name");
				
				v3.setId(id);
				v3.setFirstname(f2);
				v3.setLastname(l2);
				l1.add(v3);
				
			}
			return l1;
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;	
		
	}
	
	public void update(Regi_Vo re2)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			Statement st=c.createStatement();
			st.executeUpdate("Update jdbc1 set first_name='"+re2.getFirstname()+"',last_name='"+re2.getLastname()+"' where id='"+re2.getId()+"'");
			st.close();
			c.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Regi_Vo> search(Regi_Vo v1)
	{
		try
		{
			ArrayList<Regi_Vo> l = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from jdbc1 where first_name='"+v1.getFirstname()+"'  ");
			
			while(rs.next())
			{
				Regi_Vo v2= new Regi_Vo();
				int id=rs.getInt("id");
				String f1=rs.getString("first_name");
				String l1=rs.getString("last_name");
				
				v2.setId(id);
				v2.setFirstname(f1);
				v2.setLastname(l1);
				l.add(v2);
				
			
			}
		       return l;
	               
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
	public  List<Regi_Vo> search()
	{

		try
		{
			ArrayList<Regi_Vo> l = new ArrayList<>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from jdbc1 ");
			
			while(rs.next())
			{
				Regi_Vo v2= new Regi_Vo();
				int id=rs.getInt("id");
				String f1=rs.getString("first_name");
				String l1=rs.getString("last_name");
				
				v2.setId(id);
				v2.setFirstname(f1);
				v2.setLastname(l1);
				l.add(v2);
				
			
			}
		       return l;
	               
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
		
}
	

