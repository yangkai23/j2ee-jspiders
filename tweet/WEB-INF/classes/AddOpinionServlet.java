import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.text.*;
import java.util.*;

public class AddOpinionServlet extends HttpServlet {

	
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
		SimpleDateFormat sf=new SimpleDateFormat("dd-mmm-yyyy:hh:MM:ss");
		String today=sf.format(new java.util.Date());


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
	if(rss.next())
	{
		domainid=rss.getInt(1);
	}

String Domainname="";
System.out.println(msgid+"#########"+msg);
try{
ClusterDomain bestdomain=Classification.doClassification(domainid+"",msg);//msgid
Domainname=bestdomain.getDomain();
System.out.println("*********************the mail belongs to "+Domainname+" Cluster**************************************");

}catch(Exception ex){System.out.println("Classification ERROR");
ex.printStackTrace();}
System.out.println("OK");

String filepath=".\\";

PositiveWords.loadPositiveWords(filepath+"positive-words.txt");
System.out.println("--------------------------------");
System.out.println("Loading Nagative Dictionary......");
System.out.println("--------------------------------");
NagativeWords.loadNagativeWords(filepath+"negative-words.txt");
System.out.println("---------------------------------");
System.out.println("....Openion Analysis........");
System.out.println("----------------------------------");

String Openion_Status="";
int pscore=0;
int nscore=0;
for(String w:PositiveWords.pw)
{
if(msg.toLowerCase().contains(w.toLowerCase()))
{
pscore++;
}
}
for(String w:NagativeWords.nw)
{
if(msg.toLowerCase().contains(w.toLowerCase()))
{
nscore++;
}
}
if(pscore>=nscore)
    Openion_Status="Positive";
    else
    Openion_Status="Nagative";



con=GetCon.getCon();
st=con.createStatement();
st.execute("insert into opinions(SENDER,SUBJECT,MESSAGE,DATE_OF_POST,Domainname,pStatus) values('"+sender+"','"+sub+"','"+msg+"','"+today+"','"+Domainname+"','"+Openion_Status+"')");
System.out.println("OK");

BadWords.loadBadWords("bad-words.txt");
TreeSet<String> removeu=BadWords.pw;//new String[removes.length];
for(String wi:removeu)
{
if(msg.indexOf(" "+wi)>=0)
{
System.out.println("Bad Word("+wi+") foud,user is blocked");
st.execute("update MAILCASTINGUSER set ustatus=0 where email='"+sender+"'");
}
}
con.commit();
			out.print("Message Sucessfully Sent");
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
}catch(Exception ex){System.out.println(ex.toString());}

		
	}

}
