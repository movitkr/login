

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Prfserv
 */
@WebServlet("/Prfserv")
public class Prfserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_URL="jdbc:mysql://localhost/mov";
	static final String USER = "root";
	static final String PASS = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prfserv() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		RequestDispatcher rd=req.getRequestDispatcher("main.jsp");
		rd.include(req, res);
		
		/*Cookie ck[]=req.getCookies(); 
		if(ck!=null){
        String name=ck[0].getValue();  
        if(!name.equals("")||name!=null){   
        out.print("<b>Welcome to Profile</b>");  
        out.print("<br>Welcome, "+name);*/
		HttpSession session=req.getSession(false);
		String name=(String)session.getAttribute("name");
        if(session!=null&&name!=null)
        {   
        out.print("Hello, "+name+" Welcome to Profile");  
       
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
			
			String query = "select * from signup where name= ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
	        while(rs.next()){
	        	String Name = rs.getString("name");
	        	String mob = rs.getString("mob");
	        	String email = rs.getString("email");
	        	
	        	out.println("<br>NAME: "+Name);
	        	out.println("<br>Mob : "+mob);
	        	out.println("<br>Email:"+email);
	        	
	        }
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }
		//}
		else{  
            out.print("Please login first");  
            req.getRequestDispatcher("login.jsp").include(req, res);  
        } 
        out.close();  
	}

}
