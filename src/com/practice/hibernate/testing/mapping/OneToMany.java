package com.practice.hibernate.testing.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;

public class OneToMany {

	public static void main(String[] args) {
		
		OneToMany oneToMany = new OneToMany();
		oneToMany.writeOperation();
	}

	private void writeOperation() {
		Transaction transaction;
		try(SessionUtils utils = new SessionUtils()){
			Session session = utils.getSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" writeOperation Operation is COmpleted!...");
		}
			
	}
	

}
