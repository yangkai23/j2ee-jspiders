package com.parkerInc.mvcApp.service;
import java.util.Random;

import com.parkerInc.mvcApp.dao.EmployeeDao;
import com.parkerInc.mvcApp.dto.Employee;
public class EmployeeService {
	public Employee registerEmployee(Employee emp) {
			Random rd=new Random();
			int id=rd.nextInt();
			String emp_id="clarivate-"+id;
			emp.setEmp_id(emp_id);
			EmployeeDao dao=new EmployeeDao();
			System.out.println("Employee Object passed from EmployeeService to EmployeeDao");
			Employee empfromdao=dao.saveEmployee(emp);
			System.out.println("Received Employee Object from EmployeeDao to EmployeeService");
			return empfromdao;
	}
}
