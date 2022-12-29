package org.parkerInc.lifecycleApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = "/form",loadOnStartup = 2)
public class DemoServlet extends GenericServlet{

	public DemoServlet() {
			System.out.println("Servlet Object Created!!!");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Object initialized!!!");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
			String value=req.getParameter("con");
			double result=(double) (Integer.parseInt(value)*89.535);//business logic
			PrintWriter pw=resp.getWriter();
			pw.println("<html><body bgcolor='red'>"+ "<h1>"+ value +" euro values "+result +" in rupees"+"<h1>"
					+ "</body></html>");//presentation logic
			pw.close();
	}
	 @Override
	public void destroy() {
		System.out.println("costly resources closed");
	}
}
