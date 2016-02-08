

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loutserv
 */
@WebServlet("/Loutserv")
public class Loutserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loutserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		System.out.println("from logout.....");
		
		HttpSession session=req.getSession(false);
		if(session != null){
        RequestDispatcher rd=req.getRequestDispatcher("/main.jsp");
        rd.include(req, res);
        out.print("<center>"+"You are successfully logged out!"+"</center>");
        session.invalidate();
		}
		else
		{
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.include(req, res);
		out.print("<center>"+"plz login again"+"</center>");
			
		}
        out.close();
		System.out.println("successfully loged out");
		
	}

}
