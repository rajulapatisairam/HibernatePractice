package com.practice.hibernate.testing.unique;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.uniquekey.UniqueKey;

public class UniqueKeyTesting {

	public static void main(String[] args) {
		UniqueKeyTesting testing = new UniqueKeyTesting();
		testing.writeData();
	}

	private void writeData() {
		Transaction transaction;
		Session session;
		UniqueKey key = this.getSampleData();
		try(SessionUtils sessionUtils = new SessionUtils()){
			
			 session = sessionUtils.getSession();
			transaction = session.beginTransaction();
			session.save(key);
			transaction.commit();
		}catch(ConstraintViolationException exp){
			session = HibernateUtil.getSession();
			System.out.println("\n Duplicate Entry !"+exp.getMessage());
			exp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" Unique KEy Write Data isc COmpleted");
		}
	}

	private UniqueKey getSampleData() {
		UniqueKey key =  new UniqueKey();
		key.setKey1("Key 1");
		key.setKey2("Key 2");
		key.setName("Unique Key Name is : Updated ! ");
		return key;
	}

}
