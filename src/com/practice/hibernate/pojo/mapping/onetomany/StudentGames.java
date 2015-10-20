package com.practice.hibernate.pojo.mapping.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class StudentGames {
@Id
@GeneratedValue(generator="myGenerator")
@GenericGenerator(name="myGenerator",strategy="increment")	
private int gameId;
private String gameName;
private String gameRoles;
@ManyToOne
Students student;

public int getGameId() {
	return gameId;
}
public void setGameId(int gameId) {
	this.gameId = gameId;
}
public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public String getGameRoles() {
	return gameRoles;
}
public void setGameRoles(String gameRoles) {
	this.gameRoles = gameRoles;
}
public Students getStudent() {
	return student;
}
public void setStudent(Students student) {
	this.student = student;
}
}
