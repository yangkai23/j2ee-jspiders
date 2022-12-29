package org.parkerInc.servletApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");	
		//		req.setAttribute("pla", place);
		//		req.setAttribute("nam", name);
		//		RequestDispatcher rd=req.getRequestDispatcher("sserv");
		//		rd.forward(req, resp);
		//		HttpSession ses=req.getSession();
		//		ses.setAttribute("pla", place);
		//		ses.setAttribute("nam", name);
		Cookie cookie1=new Cookie("pla", place);
		Cookie cookie2=new Cookie("nam", name);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		resp.sendRedirect("sserv");
	}
}
