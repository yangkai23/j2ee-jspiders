import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class ComposeServlet extends HttpServlet {

	
	//public void doGet(HttpServletRequest request, HttpServletResponse response, Object parse)
	//		throws ServletException, IOException {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		
		String sender=(String)session.getAttribute("username");
		
		
		String reciever=request.getParameter("reciever_id");
		String msg=request.getParameter("message");
		String sub=request.getParameter("sub");


int msgid=0;
try{

Connection con=GetCon.getCon();
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select max(id) from INBOX6");
if(rs.next())
msgid=rs.getInt(1);

}catch(Exception ex){ex.printStackTrace();}
    msgid++;
String Domainname="";
System.out.println(msgid+"#########"+msg);
try{
ClusterDomain bestdomain=Classification.doClassification(msgid+"",msg);
Domainname=bestdomain.getDomain();
 System.out.println("*********************the mail belongs to "+Domainname+" Cluster**************************************");

}catch(Exception ex){System.out.println("Classification ERROR");
ex.printStackTrace();}





		int i=SendMessage.sendMsg(sender,reciever,msg,sub,Domainname);
		if(i>0){
			
	            //int j=parse.Integer(reciever);
				//if(j>0){
		
			out.print("Message Sucessfully Sent");
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
		else{
			out.print("Sorry,Message was not sent");
			RequestDispatcher rd=request.getRequestDispatcher("compose.jsp");
			rd.include(request, response);
		}
		
	}

}
