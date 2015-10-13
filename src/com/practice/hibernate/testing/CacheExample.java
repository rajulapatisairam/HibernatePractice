package com.practice.hibernate.testing;

import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.Student;

public class CacheExample {
	public static void main(String...str){
		CacheExample cacheExample = new CacheExample();
		//cacheExample.stateLessSessionOperation();
		//cacheExample.stateSessionOperation();
		Student student = cacheExample.stateSessionWithRefreshOperation();
		System.out.println("  Student Name is: "+student.getStudentName());
		
	}

	private Student stateSessionWithRefreshOperation() {
		Transaction transaction;
		Student student1;
		Student student2 = null;
		Session session = null;
		try{
			 session = HibernateUtil.getSession();
			student1 = (Student) session.get(Student.class, 1);
			System.out.println("\n B4 Close Session() student Name is : "+student1.getStudentName());
			session.close();
			System.out.println("\n After Close Session() student Name is : "+student1.getStudentName());
			session = HibernateUtil.getSession();
			student2 = (Student) session.get(Student.class, 1);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" State Session With Refresh Operatiosn are Completed !");
		}
		return student2;
		
	}

	private void stateSessionOperation() {
		Transaction transaction;
		Student student1;
		Student student2;
		try(SessionUtils utils = new SessionUtils()){
			Session session = utils.getSession();
			student1 = (Student) session.get(Student.class, 1);
			System.out.println("\n student Name is : "+student1.getStudentName());
			student2 = (Student) session.get(Student.class, 1);
			System.out.println("\n student Name is : "+student2.getStudentName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" State Session Operatiosn are Completed !");
		}		
	}

	private void stateLessSessionOperation() {
		Transaction transaction;
		Student student1;
		Student student2;
		try(SessionUtils utils = new SessionUtils()){
			StatelessSession session = HibernateUtil.getStateLessSession();
			student1 = (Student) session.get(Student.class, 1);
			System.out.println("\n student Name is : "+student1.getStudentName());
			student2 = (Student) session.get(Student.class, 1);
			System.out.println("\n student Name is : "+student2.getStudentName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" Cahce Operatiosn are Completed !");
		}
	}

}
