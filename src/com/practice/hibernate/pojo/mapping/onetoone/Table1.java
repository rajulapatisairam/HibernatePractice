package com.practice.hibernate.pojo.mapping.onetoone;

public class Table1 {
	private int t1_primaryKey;
	private String t1_field1;
	private String t1_field2;
	private Table2 table2;
	public int getT1_primaryKey() {
		return t1_primaryKey;
	}
	public void setT1_primaryKey(int t1_primaryKey) {
		this.t1_primaryKey = t1_primaryKey;
	}
	public String getT1_field1() {
		return t1_field1;
	}
	public void setT1_field1(String t1_field1) {
		this.t1_field1 = t1_field1;
	}
	public String getT1_field2() {
		return t1_field2;
	}
	public void setT1_field2(String t1_field2) {
		this.t1_field2 = t1_field2;
	}
	public Table2 getTable2() {
		return table2;
	}
	public void setTable2(Table2 table2) {
		this.table2 = table2;
	}
	
	
}
