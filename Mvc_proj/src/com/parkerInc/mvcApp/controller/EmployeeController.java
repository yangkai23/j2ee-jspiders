package com.parkerInc.mvcApp.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.parkerInc.mvcApp.dto.Employee;
import com.parkerInc.mvcApp.service.EmployeeService;
public class EmployeeController extends HttpServlet {
	Employee emp=null;
	Employee empfromservice=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!req.getParameter("fn").isEmpty()&&!req.getParameter("ln").isEmpty()&&!req.getParameter("em").isEmpty()&&!req.getParameter("pw").isEmpty()) {
			emp=new Employee();
			emp.setFirst_name(req.getParameter("fn"));
			emp.setLast_name(req.getParameter("ln"));
			emp.setEmail_id(req.getParameter("em"));
			emp.setPassword(req.getParameter("pw")); 
			System.out.println("Employee Object passed from EmployeeController to EmployeeService");
			EmployeeService eserv=new EmployeeService();
			empfromservice=eserv.registerEmployee(emp);
			System.out.println("Received Employee Object from EmployeeService to EmployeeController");
			}
		else {
			emp=null;
			System.out.println("invalid data");
		}
		RequestDispatcher dispatcher=null;
		if (empfromservice!=null) {
			req.setAttribute("username", empfromservice.getFirst_name()+" "+empfromservice.getLast_name());
			req.setAttribute("empid", empfromservice.getEmp_id());
			dispatcher=req.getRequestDispatcher("Success.jsp");
		} else {
			dispatcher=req.getRequestDispatcher("Error.jsp");
		}
		dispatcher.forward(req, resp);
	}
	}

