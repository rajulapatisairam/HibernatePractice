package com.practice.hibernate.pojo.associations;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id",nullable=false,unique=true)
private int vendorId;
private String vendorName;
private String vendorAdd;
@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
private Set<Customer> customers = new LinkedHashSet<Customer>();

public int getVendorId() {
	return vendorId;
}

public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}

public String getVendorName() {
	return vendorName;
}

public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}

public String getVendorAdd() {
	return vendorAdd;
}

public void setVendorAdd(String vendorAdd) {
	this.vendorAdd = vendorAdd;
}

public Set<Customer> getCustomers() {
	return customers;
}

public void setCustomers(Set<Customer> customers) {
	this.customers = customers;
}

 
}
