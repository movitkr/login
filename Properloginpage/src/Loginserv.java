

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loginserv
 */
@WebServlet("/Loginserv")
public class Loginserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_URL="jdbc:mysql://localhost/mov";
	static final String USER = "root";
	static final String PASS = "root";

    /**
     * Default constructor. 
     */
    public Loginserv() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Connection conn=null;
		PreparedStatement pstmt=null;
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		try {
			System.out.println("loading......");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("db loaded....");
			
			String sql="select password from signup where name ="+"(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
	        
	        ResultSet rs=pstmt.executeQuery();
	        if(rs.next()){
	        String pas =rs.getString("password");
	        if(password.equals(pas))
	        {
	          out.print("successfully logged in");
	          /*Cookie ck=new Cookie("name",name);  
	          res.addCookie(ck);*/
	          HttpSession session=req.getSession();  
		      session.setAttribute("name",name);
	          req.getRequestDispatcher("main.jsp").forward(req, res);
	        	
	        }
	        else
	        {
	         out.print("incorrect password!!!!");
	         out.print("plz login again");
	         req.getRequestDispatcher("login.jsp").include(req, res);
	        }
	       }
	       else
	       {
	    	 out.print("Invalid user!!!");
	    	 out.print("signup first!!!");
	    	 req.getRequestDispatcher("login.jsp").include(req, res);
	       }
	        
	        
	        System.out.println("done...");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
