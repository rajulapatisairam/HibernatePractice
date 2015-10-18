package com.practice.hibernate.pojo.mapping;


import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ManyToOneTable")
public class ManyToOne1 {
	@Id
	@GeneratedValue(generator="myGenerator")
	@GenericGenerator(name="myGenerator",strategy="increment")
	private int primaryKey;
	private String column1;
	private String column2;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="primaryKey", nullable=false)
	private ManyToOne2 manyToOne2;
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
	public ManyToOne2 getManyToOne2() {
		return manyToOne2;
	}
	public void setManyToOne2(ManyToOne2 manyToOne2) {
		this.manyToOne2 = manyToOne2;
	}
	
	
	

}
