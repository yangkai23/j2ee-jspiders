import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("email");
		String password=request.getParameter("password");
boolean status=VerifyLogin.checkLogin(uname,password);
int us=0;
try{
Connection con=GetCon.getCon();
		//PreparedStatement ps=con.prepareStatement("Select * from MAILCASTINGUSER where EMAILADD = ? and PASSWORD =?");
		PreparedStatement ps=con.prepareStatement("Select ustatus from MAILCASTINGUSER where email = ? and password =?");
		
		ps.setString(1,uname);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) { us=rs.getInt(1); System.out.println(us);}
	
}catch(Exception ex){System.out.println(ex);}

		
		if(status==true){

			if(us==0)
			{
		String Error="This User  is blocked due to bad Posts";
			request.setAttribute("Error", Error);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
			}
else{
			HttpSession session=request.getSession();
			session.setAttribute("username",uname);
			out.print("Welcome    " + uname);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
	}
	}
		else{
			String Error="Please check your EMail and Password";
			request.setAttribute("Error", Error);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			
		}
		out.close();
	}

}
