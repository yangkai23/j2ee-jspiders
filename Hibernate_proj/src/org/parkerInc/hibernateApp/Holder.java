package org.parkerInc.hibernateApp;
import javax.persistence.*;
@Entity
@Table(name = "holder_details")
public class Holder {
	@Id
	@GeneratedValue
	private int holder_id;
	private String holder_name;
	public int getHolder_id() {
		return holder_id;
	}
	public void setHolder_id(int holder_id) {
		this.holder_id = holder_id;
	}
	public String getHolder_name() {
		return holder_name;
	}
	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}
	
}
