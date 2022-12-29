package org.parkerInc.hibernateApp;
import javax.persistence.*;
@Entity
@Table(name = "passport_details")
public class Passport {
	@Id
	@GeneratedValue
	private int passport_id;
	private String passport_name;
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getPassport_name() {
		return passport_name;
	}
	public void setPassport_name(String passport_name) {
		this.passport_name = passport_name;
	}
}
