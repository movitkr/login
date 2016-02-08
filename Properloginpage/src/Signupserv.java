

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Signupserv
 */
@WebServlet("/Signupserv")
public class Signupserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JD_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL="jdbc:mysql://localhost/mov";
	
	static final String USER = "root";
	static final String PASS = "root";
   
    public Signupserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Connection conn=null;
		java.sql.PreparedStatement pstmt=null;
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String mob=req.getParameter("mob");
		String email=req.getParameter("email");
		
		try {
			System.out.println("loading....");
			Class.forName(JD_DRIVER);
			System.out.println("loaded successfully...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			String query = "insert into signup(name,password,mob,email) values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, mob);
            pstmt.setString(4, email);
           
            int count = pstmt.executeUpdate();
            System.out.println(count);
            out.print("Sucessfully Signed up");
            out.print("<br>you can login now");
            req.getRequestDispatcher("login.jsp").include(req, res);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
