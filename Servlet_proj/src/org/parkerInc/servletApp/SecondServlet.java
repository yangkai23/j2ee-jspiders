package org.parkerInc.servletApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String st="",s="";
//		HttpSession sess=req.getSession();
//		String name=(String) sess.getAttribute("nam");
//			String place=(String) sess.getAttribute("pla");
          Cookie cookies[]=req.getCookies();
          for (Cookie cookie : cookies) {
					if(cookie.getName().equals("nam"))
			        	 st=cookie.getValue();
					if(cookie.getName().equals("pla"))
			        	 s=cookie.getValue();
		}
          ServletContext context=req.getServletContext();
          int id=Integer.parseInt(context.getInitParameter("id"));
          ServletConfig config=getServletConfig();
          int id1=Integer.parseInt(config.getInitParameter("id"));
//			String name=req.getParameter("nam");
//			String place =req.getParameter("pla");
			PrintWriter pw=resp.getWriter();
			pw.println("<html><body bgcolor='orange'>");
			pw.println("Name : "+st+" Location "+s+" Id: "+id+" id2 : "+id1);
			pw.println("</body></html>");
			System.out.println("Done");
	}
}