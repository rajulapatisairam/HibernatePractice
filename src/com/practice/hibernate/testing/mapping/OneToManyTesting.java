package com.practice.hibernate.testing.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.mapping.onetomany.StudentGames;
import com.practice.hibernate.pojo.mapping.onetomany.Students;
import com.practice.hibernate.testing.Operations;



public class OneToManyTesting implements Operations {

	public static void main(String[] args) {
		OneToManyTesting OneToManyTesting_obj = new OneToManyTesting();
		OneToManyTesting_obj.writeOperation();
	}

	@Override
	public void readOperation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOperation() {
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			transaction = session.beginTransaction();
			Students Students_obj = new Students();
			StudentGames StudentGames_obj1 = new StudentGames();
			StudentGames StudentGames_obj2 = new StudentGames();
			
			Students_obj.setStudentName("Sairam Rajulapati");
			Students_obj.setAddress("vadali");
			
			StudentGames_obj1.setGameName("RagB");
			StudentGames_obj1.setGameRoles("No RUles");
			//StudentGames_obj1.setStudent(Students_obj);
			StudentGames_obj2.setGameName("Food Ball");
			StudentGames_obj2.setGameRoles("Should Play With Legs!...");
			//StudentGames_obj2.setStudent(Students_obj);
			Students_obj.getStudentGames().add(StudentGames_obj2);
			//Students_obj.getStudentGames().add(StudentGames_obj1);
			session.save(Students_obj);
			//session.save(StudentGames_obj1);
			//session.save(StudentGames_obj2);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Wrtie   Operation is COmpleted!...");
		}
	}
}
