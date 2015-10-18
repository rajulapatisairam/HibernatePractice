package com.practice.hibernate.pojo.mapping;

public class Table2 {

	private int t2_primaryKey;
	private String t2_field1;
	private String t2_field2;
	private Table1 table1;
	public int getT2_primaryKey() {
		return t2_primaryKey;
	}
	public void setT2_primaryKey(int t2_primaryKey) {
		this.t2_primaryKey = t2_primaryKey;
	}
	public String getT2_field1() {
		return t2_field1;
	}
	public void setT2_field1(String t2_field1) {
		this.t2_field1 = t2_field1;
	}
	public String getT2_field2() {
		return t2_field2;
	}
	public void setT2_field2(String t2_field2) {
		this.t2_field2 = t2_field2;
	}
	public Table1 getTable1() {
		return table1;
	}
	public void setTable1(Table1 table1) {
		this.table1 = table1;
	}
	
}
