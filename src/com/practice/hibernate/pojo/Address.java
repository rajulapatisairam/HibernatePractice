package com.practice.hibernate.pojo;

public class Address {
	private int addrId;
 private String city;
 private String state;
private Student student;

 
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public int getAddrId() {
	return addrId;
}
public void setAddrId(int addrId) {
	this.addrId = addrId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
 
 
 
}
