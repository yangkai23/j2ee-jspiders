package org.parkerInc.postApp;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = "/sd",loadOnStartup = 2)
public class PostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student_id=req.getParameter("id"	);
		int id=Integer.parseInt(student_id);
		String student_name=req.getParameter("nm");
		String student_dept=req.getParameter("dept");
		String student_perc=req.getParameter("perc");
		double perc=Double.parseDouble(student_perc);
		
		PrintWriter pw=resp.getWriter();
		pw.println("<html><body bgcolor='blue'>"
		+ "<h1>user is "+student_name+" pursuing Degree in "+student_dept+" stream "+"</h1>"
		+ "</body></html>");//presentation logic
		pw.close();
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into servletprct.student_details values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, student_name);
			pstmt.setString(3, student_dept);
			pstmt.setDouble(4, perc);
			pstmt.executeUpdate();//presistence logic 
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
