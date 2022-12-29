package org.parkerInc.hibernateApp;
import java.util.*;

import javax.persistence.*;
@Entity
@Table(name = "owner_details")
public class Owner {
	@Id
	@GeneratedValue
private int owner_id;
private String owner_name;
@OneToMany(cascade = CascadeType.ALL)
private List<Car> cars;
public int getOwner_id() {
	return owner_id;
}
public void setOwner_id(int owner_id) {
	this.owner_id = owner_id;
}
public String getOwner_name() {
	return owner_name;
}
public void setOwner_name(String owner_name) {
	this.owner_name = owner_name;
}
public List<Car> getCars() {
	return cars;
}
public void setCars(List<Car> cars) {
	this.cars = cars;
}

}
