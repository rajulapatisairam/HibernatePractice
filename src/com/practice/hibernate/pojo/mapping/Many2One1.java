package com.practice.hibernate.pojo.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Many2One1 {
	@Id
	@Column(name="primaryKey1")
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator",strategy="increment")
	private int primaryKey1;
	private String column1;
	private String column2;
	public int getPrimaryKey() {
		return primaryKey1;
	}
	public void setPrimaryKey(int primaryKey1) {
		this.primaryKey1 = primaryKey1;
	}
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	
}
