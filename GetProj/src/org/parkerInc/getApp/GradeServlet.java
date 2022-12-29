package org.parkerInc.getApp;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/grade")
public class GradeServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double perc=(double) req.getAttribute("perc");
		String name=(String) req.getAttribute("name");
		String dept=(String) req.getAttribute("dept");
		PrintWriter pw=resp.getWriter();
		String st="";
		if(perc==0) {
			pw.println("<html><body bgcolor='red'>"
					+ "<h1>Candidate data not found</h1>"
					+ "</body></html>");
		}
		if(perc>=90)
			st="Grade S";
		else if(perc<90&&perc>=80)
		st="Grade A";
		else if(perc<80&&perc>=70)
			st="Grade B";
		else if(perc<70&&perc>=60)
			st="Grade C";
		else if(perc<60&&perc>=50)
			st="Grade D";
		else
			st="Grade F";
		pw.println("<html><body bgcolor='green'>"
				+ "<h1>Candidate from "+dept+" department by name "+name+" scored "+perc+" percentage with overall grade "+st+" in degree </h1>"
				+ "</body></html>");	
}
}
