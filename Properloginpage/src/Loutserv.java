

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		out.print("FROM_LOGOUT");
		
		RequestDispatcher rd=req.getRequestDispatcher("main.jsp");
		rd.include(req, res);
		
		/*Cookie ck[]=req.getCookies();  
        if(ck!=null){  
        String name=ck[0].getValue(); 
        if(!name.equals("")||name!=null){  
        	Cookie cok= new Cookie("name", "");
    		cok.setMaxAge(0);
    		res.addCookie(cok);
    		out.println("sucessfully loged out");
    		out.println("wanna login again");
    		req.getRequestDispatcher("login.html").include(req, res);
        }  
        }
        else{  
            out.print("Please login first");  
            req.getRequestDispatcher("login.html").include(req, res);  
        }*/
		HttpSession session=req.getSession();  
        session.invalidate();
        out.print("You are successfully logged out!");  
        
        out.close();
		
		
	}

}
