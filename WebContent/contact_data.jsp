<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Conatct -> JDBC</title>
	</head>
	<body>
		<%! String query, n, e, c;%>
		<%! Connection cn;
			PreparedStatement ps;
		%>
		<%
		
			n = request.getParameter("name");
			e = request.getParameter("email");
			c = request.getParameter("text");
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
				cn = DriverManager.getConnection("jdbc:odbc:Vishal's_Server");
				
				query = "insert into User_ContactData_Website values(?, ?, ?)";
				
				ps = cn.prepareStatement(query);
				
				ps.setString(1, n);
				ps.setString(2, e);
				ps.setString(3, c);
				
				ps.executeUpdate();
				
				System.out.println("Thank You for your response!");
			}
			catch (ClassNotFoundException e)
			{	e.printStackTrace();	}
			catch (SQLException e)
			{	e.printStackTrace();	}
		%>
	</body>
</html>