package org.parkerInc.hibernateApp;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class OneToOneDao {
	public static void main(String[] args) {
		Passport passport=new Passport();
		passport.setPassport_name("Shanmukha Anirudh");
		Person person=new Person();
		person.setPerson_name("Anirudh");
		person.setPassport(passport);
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Transaction tran=ses.beginTransaction();
		ses.save(person);
		tran.commit();
		ses.close();
	}
}
