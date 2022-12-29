package com.parkerInc.mvcApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.parkerInc.mvcApp.dto.Employee;
public class EmployeeDao {
	public Employee saveEmployee(Employee emp) {
		System.out.println("Received Employee Object from EmployeeService to EmployeeDao");
		int primarykey=0;
		Transaction tran=null;
		if(emp!=null) {
			try {
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef=conf.buildSessionFactory();
				Session ses=sef.openSession();
				tran=ses.beginTransaction();
				primarykey=(int)ses.save(emp);
				tran.commit();
				ses.close();
			} catch (HibernateException e) {
				tran.rollback();
				System.out.println("transaction was rolled back");
				return null;
			
			}
		}
		if (primarykey!=0) {
			System.out.println("Employee object passed from EmployeeDao to EmployeeService");
			return emp;
		} else {
			System.out.println("Transaction Failed");
			return null;
		}
	}
}
