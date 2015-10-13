package com.practice.hibernate.testing.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.Student;

public class BasicCrudOperations {
        Student student;
	public static void main(String[] args) {
		BasicCrudOperations operations = new BasicCrudOperations();
		operations.operations();
	}

	private void operations() {
		Student student = new Student();
		student.setStudentClass("Java");
		student.setStudentName("Sairam Rajulapati");
		insert(student);
		System.out.println("\n Student id is : "+student.getStudentId());
		update();
		delete();
		read();
		
	}

	private void read() {
		// TODO Auto-generated method stub
		
	}

	private void delete() {
		// TODO Auto-generated method stub
		
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void insert(Student student) {
		Transaction transaction = null;
		try(SessionUtils sessionUtils = new SessionUtils()){
			Session session = sessionUtils.getSession();
			transaction = session.beginTransaction();
			session.save(student);
			student.setStudentName("Jaggu ");
			transaction.commit();
			System.out.println("\n Student Id is : "+student.getStudentId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			System.out.println(" Student Record Insertion is Finished ");
		}
}

}
