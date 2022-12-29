package org.parkerInc.hibernateApp;
import java.util.*;

import javax.persistence.*;
@Entity
@Table(name = "Student_Details")
public class Student {
	@Id
	@GeneratedValue
private int student_id;
private String student_name;
@ManyToMany(cascade = CascadeType.ALL)
private List<Course> courses;
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public List<Course> getCourses() {
	return courses;
}
public void setCourses(List<Course> courses) {
	this.courses = courses;
}

}
