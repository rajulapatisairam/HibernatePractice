/**
 * 
 */
package com.practice.hibernate.pojo.associations;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Sairam Rajulapati
 *
 */
@Entity
@Table(name="employeeproject")
public class EmployeeProject {
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",
	parameters=@Parameter(name="property",value="employe"))
private Integer employee_projectId;
private String projectName;
@OneToOne(fetch=FetchType.EAGER)
@PrimaryKeyJoinColumn
private Employee employe;
public Integer getProjectId() {
	return employee_projectId;
}
public void setProjectId(Integer projectId) {
	this.employee_projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public Employee getEmploye() {
	return employe;
}
public void setEmploye(Employee employe) {
	this.employe = employe;
}

}
