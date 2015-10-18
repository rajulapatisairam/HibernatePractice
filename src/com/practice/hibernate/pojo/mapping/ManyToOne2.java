package com.practice.hibernate.pojo.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ManyToOne2 {
	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator",strategy="increment")
	private int primaryKey;
	private String column1;
	private String column2;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="primaryKey1",nullable=true)
	private Many2One1 many2One1;
	public int getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
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
	public Many2One1 getMany2One1() {
		return many2One1;
	}
	public void setMany2One1(Many2One1 many2One1) {
		this.many2One1 = many2One1;
	}
}
