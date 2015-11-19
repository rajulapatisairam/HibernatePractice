/**
 * 
 */
package com.practice.hibernate.testing.associations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.associations.Employee;
import com.practice.hibernate.pojo.associations.EmployeeProject;

/**
 * @author Sairam Rajulapati
 *
 */
public class OneToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneToOne  oneToOne = new OneToOne();
		oneToOne.operations();
	}

	private void operations() {
			writeOperation();
		//readOperation();
	}

	private void readOperation() {
		//hib
	}

	private void writeOperation() {
			
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				transaction = session.beginTransaction();
				Employee employee = new Employee();
				EmployeeProject employeeProject = new EmployeeProject();
				employee.setEmployeeName("Sairam ");
				
				employeeProject.setProjectName("Hibenrate practice");
				employeeProject.setEmploye(employee);
				employee.setEmployeeProject(employeeProject);
				session.save(employee);
				//session.save(employeeProject);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Write Operation   Operation is COmpleted!...");
			}
	}

}
