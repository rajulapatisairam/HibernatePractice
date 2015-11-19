/**
 * 
 */
package com.practice.hibernate.pojo.associations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sairam Rajulapati
 * 
 *  For One to Many Example
 */
@Entity
@Table(name="Vendorcustomer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_Id",unique=true, nullable=false, 
			columnDefinition=" Primary key ",length=10)
private Integer customerId;
	@Column(name="customer_Name",length=50, columnDefinition=" Customer Name")
private String customerName;
private String customerAddress;
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="vendor_id",nullable=false)
private Vendor vendor;
public Integer getCustomerId() {
	return customerId;
}
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public Vendor getVendor() {
	return vendor;
}
public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}

}
