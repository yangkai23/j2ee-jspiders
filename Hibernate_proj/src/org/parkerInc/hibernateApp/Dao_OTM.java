package org.parkerInc.hibernateApp;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class Dao_OTM {
	public static void main(String[] args) {
		Car c1=new Car();
		c1.setCar_model("q7");
		c1.setCar_name("Audi");

		Car c2=new Car();
		c2.setCar_model("urus");
		c2.setCar_name("lambhorgini");

		Car c3=new Car();
		c3.setCar_model("vento");
		c3.setCar_name("volkswagon");
		List<Car> cl=new ArrayList<Car>();
		cl.add(c1);
		cl.add(c2);
		cl.add(c3);
		Owner owner=new Owner();
		owner.setOwner_name("Parker");
		owner.setCars(cl);
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		Transaction tran=ses.beginTransaction();
		ses.save(owner);
		tran.commit();
		ses.close();
	}
}
