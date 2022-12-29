package org.parkerInc.hibernateApp;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Dao_MTM {
	public static void main(String[] args) {
		Course c1=new Course();
		c1.setCourse_name("J2EE");
		Course c2=new Course();
		c2.setCourse_name("Hibernate");
		Course c3=new Course();
		c3.setCourse_name("Spring");

		List<Course> courselist=new ArrayList<Course>();
		courselist.add(c1);
		courselist.add(c2);
		courselist.add(c3);

		Student s1=new Student();
		s1.setStudent_name("Anirudh");
		s1.setCourses(courselist);

		Student s2=new Student();
		s2.setStudent_name("prahith");
		s2.setCourses(courselist);
			
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Transaction tran=ses.beginTransaction();
		ses.save(s1);
		ses.save(s2);
		tran.commit();
		ses.close();
	}
}
