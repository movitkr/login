

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
 * Servlet implementation class Hservlet
 */
@WebServlet("/Hservlet")
public class Hservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  res.setContentType("text/html");
	  PrintWriter out=res.getWriter();
	  RequestDispatcher rd=req.getRequestDispatcher("main.jsp");
	  rd.include(req, res);
	  
	  System.out.println("from home.....");
	  
	  HttpSession session =req.getSession(false);
	  String name=(String)session.getAttribute("name");
	  if(session!=null&& name!=null)
	  {
		out.println("<center>"+"Welcome:"+name+"</center>");
	  }
	  else{
		out.println("<center>"+"You must login First"+"</center>");
		req.getRequestDispatcher("login.jsp").include(req, res);
	  }
	  System.out.println("home displayed successfully");
	}

}
