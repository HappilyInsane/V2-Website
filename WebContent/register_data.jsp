<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register -> JDBC</title>
	</head>
	<body>
		<%! String query, fn, ln, pno, ei, pw;%>
		<%! Connection cn;
			PreparedStatement ps;
		%>
		<%
		
			fn = request.getParameter("fname");
			ln = request.getParameter("lname");
			pno = request.getParameter("phone");
			ei = request.getParameter("email");
			pw = request.getParameter("password");
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
				cn = DriverManager.getConnection("jdbc:odbc:Vishal's_Server");
				
				query = "insert into User_Data_Website values(?, ?, ?, ?, ?)";
				
				ps = cn.prepareStatement(query);
				
				ps.setString(1, fn);
				ps.setString(2, ln);
				ps.setString(3, pno);
				ps.setString(4, ei);
				ps.setString(5, pw);
				
				ps.executeUpdate();
				
				System.out.println("You are registered successfully!");
			}
			catch (ClassNotFoundException e)
			{	e.printStackTrace();	}
			catch (SQLException e)
			{	e.printStackTrace();	}
		%>
	</body>
</html>