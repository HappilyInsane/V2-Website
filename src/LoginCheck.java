import java.sql.*;  
  
public class LoginCheck
{  public static boolean validate(String name,String pass)
	{  
		boolean status=false;  
		try
		{  
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
			Connection con=DriverManager.getConnection("jdbc:odbc:Vishal's_Server");  
			      
			PreparedStatement ps=con.prepareStatement("select * from User_Data_Website where first_name=? and password=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  
			      
			ResultSet rs=ps.executeQuery(); 
			
			status=rs.next();
		}
		catch(Exception e){System.out.println(e);}  
		
		return status;  
	}  
}