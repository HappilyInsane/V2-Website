import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		RequestDispatcher rd = req.getRequestDispatcher("Links.html");
		rd.include(req, res);
		
		String Name = req.getParameter("Name");
		String Password = req.getParameter("Password");
		
					
		pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Login Servlet</title>");  
        pw.println("<link rel='stylesheet' href='style_LoginServlet.css' type='text/css'>");
        pw.println("</head>");
        pw.println("<body class='body'>");
        
        if (LoginCheck.validate(Name, Password))
        {
        	HttpSession hs = req.getSession();
        	hs.setAttribute("Name", Name);
			pw.println("<br><br>Hello " + Name);
			pw.println("<br>");
			pw.println("<br><a href='coupon.html'>Click Here to get Coupons!</a>");
		}
		else 
		{
			pw.println("<br>");
			pw.println("<br><br>Username or Password Incorrect!");
		}
        
        pw.println("</body>");
		pw.println("</html>");

	}

}
