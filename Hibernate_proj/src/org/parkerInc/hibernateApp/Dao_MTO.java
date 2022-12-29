package org.parkerInc.hibernateApp;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class Dao_MTO {
public static void main(String[] args) {
	Holder holder=new Holder();
	holder.setHolder_name("Anirudh");
	
	Bike b1=new Bike();
	b1.setBike_name("RE Gt650");
	b1.setHolder(holder);
	
	Bike b2=new  Bike();
	b2.setBike_name("Interceptor");
	b2.setHolder(holder);
	
	Bike b3=new Bike();
	b3.setBike_name("Triumph");
	b3.setHolder(holder);
	
	Configuration conf=new Configuration();
	conf.configure();
	SessionFactory sef=conf.buildSessionFactory();
	Session ses=sef.openSession();
	Transaction tran=ses.beginTransaction();
	ses.save(b1);
	ses.save(b2);
	ses.save(b3);
	tran.commit();
	ses.close();
}
}
