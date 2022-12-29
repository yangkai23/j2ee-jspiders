package org.parkerInc.hibernateApp;

import javax.persistence.*;

@Entity
@Table(name = "person_details")
public class Person {
	@Id
	@GeneratedValue
	private int person_id;
	private String person_name;
	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
}
