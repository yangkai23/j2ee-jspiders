import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class AddTopicServlet extends HttpServlet {

	
	//public void doGet(HttpServletRequest request, HttpServletResponse response, Object parse)
	//		throws ServletException, IOException {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		
		String sender=(String)session.getAttribute("username");
		
		
		//String reciever=request.getParameter("reciever_id");
		String msg=request.getParameter("message");
		String sub=request.getParameter("sub");


int msgid=0;
int domainid=0;
try{

Connection con=GetCon.getCon();
Statement st=con.createStatement();
ResultSet rss=st.executeQuery("select id from domains where domain_name='"+sub+"'");
if(rss.next())
{
domainid=rss.getInt(1);
}

if(domainid==0)
{
	rss=st.executeQuery("select max(id) from domains");
	if(rss.next())
	{
		domainid=rss.getInt(1);
		domainid++;
		st.execute("insert into DOMAINS(domain_name) values('"+sub+"')");
	}

}
st.execute("insert into topics(subject,description) values('"+sub+"','"+msg+"')");

String[] stopwords={" is ","Is "," the ","The "," this ","This "," was "};
for(String word:stopwords)
{
msg=msg.replace(word," ");
}
String[] words=msg.split(" ");

for(int i=0;i<words.length;i++)
{
st.execute("insert into WORDCLUSTER(word,DOMAINID) values('"+words[i]+"','"+domainid+"')");
}
con.commit();
//con.close();
			out.print("Message Sucessfully Sent");
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
}catch(Exception ex){System.out.println(ex.toString());}
		
	}

}
