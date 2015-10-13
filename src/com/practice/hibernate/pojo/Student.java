package com.practice.hibernate.pojo;

public class Student {

	private int studentId;
	private String studentName;
	private String studentClass;
	private Address address;

	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
