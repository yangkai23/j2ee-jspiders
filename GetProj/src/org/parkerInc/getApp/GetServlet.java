package org.parkerInc.getApp;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet(urlPatterns = "/fetch",loadOnStartup = 0)
public class GetServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String student_name=req.getParameter("nm");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query="select * from servletprct.student_details where name=?";
		double perc=0;
		req.setAttribute("name", student_name);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Admin");
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, student_name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				perc=rs.getDouble("perc");
				String dept=rs.getString("dept");
				req.setAttribute("dept", dept);
				req.setAttribute("perc", perc);
			}
			else {
				req.setAttribute("dept", perc);
			}
			RequestDispatcher rd=req.getRequestDispatcher("grade");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
