import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		RequestDispatcher rd = req.getRequestDispatcher("Links.html");
		rd.include(req, res);
		
		pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Logout Servlet</title>");  
        pw.println("<link rel='stylesheet' href='style_LoginServlet.css' type='text/css'>");
        pw.println("</head>");
        pw.println("<body class='body'>");
        
		
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			pw.println("<br><br>");
			pw.println("<br><br>Please Login First");
		}
		else
		{
			hs.invalidate();
			pw.println("<br><br>");
			pw.println("<br><br>You are successfully logged out!");
		}				
	}

}
