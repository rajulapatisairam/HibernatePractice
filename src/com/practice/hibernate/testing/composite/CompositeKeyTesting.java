package com.practice.hibernate.testing.composite;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.composite.Composite;

public class CompositeKeyTesting {

	public static void main(String[] args) {
		CompositeKeyTesting testing = new CompositeKeyTesting();
		testing.writeData();
	}

	private void writeData() {
		Transaction transaction;
		try(SessionUtils sessionUtils = new SessionUtils()){
			Composite composite = getCompositeSampleData();
			Session session = sessionUtils.getSession();
			transaction = session.beginTransaction();
			session.save(composite);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" Compostie Table Data Reading is Over");
		}
	}

	private Composite getCompositeSampleData() {
		Composite composite = new Composite();
		composite.setKey1("str1");
		composite.setKey2("str2");
		composite.setKey3("str3");
		
		return composite;
	}

}
