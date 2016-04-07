import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		RequestDispatcher rd = req.getRequestDispatcher("Links.html");
		rd.include(req, res);
		
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			pw.println("<br>");
			pw.println("Please Login First");
		}
		else
		{
			pw.println("<br><a href='coupon.html'>Click Here to get Coupons!</a>");
		}						
	}

}
