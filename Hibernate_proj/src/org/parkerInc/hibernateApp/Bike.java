package org.parkerInc.hibernateApp;
import javax.persistence.*;
@Entity
@Table(name = "bike_details")
public class Bike {
	@Id
	@GeneratedValue
private int bike_id;
private String bike_name;
@ManyToOne(cascade = CascadeType.ALL)
private Holder holder;
public int getBike_id() {
	return bike_id;
}
public void setBike_id(int bike_id) {
	this.bike_id = bike_id;
}
public String getBike_name() {
	return bike_name;
}
public void setBike_name(String bike_name) {
	this.bike_name = bike_name;
}
public Holder getHolder() {
	return holder;
}
public void setHolder(Holder holder) {
	this.holder = holder;
}

}
