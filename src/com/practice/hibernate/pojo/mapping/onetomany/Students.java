package com.practice.hibernate.pojo.mapping.onetomany;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Students {
@Id
@Column(name="studentId")
@GeneratedValue(generator="myGenerator")
@GenericGenerator(name="myGenerator",strategy="increment")
	private int studentId;
	private String studentName;
	private String address;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="gameId")
	private List<StudentGames> studentGames;
	
	public Students() {
		super();
		this.setStudentGames(new LinkedList<StudentGames>());
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<StudentGames> getStudentGames() {
		return studentGames;
	}
	public void setStudentGames(List<StudentGames> studentGames) {
		this.studentGames = studentGames;
	}
}
