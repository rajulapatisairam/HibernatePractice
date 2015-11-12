package com.practice.others;

/**
 * @author Sairam Rajulapati
 */
public class Pojo {
	private int primaryKey;
	@MyAnnotation(columName="1st Column")
	private String column1;
	@MyAnnotation(columName="2nd Column")
	private String column2;
	@MyAnnotation(columName="3rd Column")
	private String column3;
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
	public String getColumn3() {
		return column3;
	}
	public void setColumn3(String column3) {
		this.column3 = column3;
	}
	
	

}
