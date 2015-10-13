package com.practice.hibernate.pojo.composite;

import java.io.Serializable;

public class Composite  implements Serializable{

	private Integer primaryKey;
	private String key1;
	private String key2;
	private String key3;
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getKey3() {
		return key3;
	}
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	
	
}