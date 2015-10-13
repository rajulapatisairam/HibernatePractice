package com.practice.hibernate.testing.session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.Address;
import com.practice.hibernate.pojo.Customers;
import com.practice.hibernate.pojo.Student;


public class HibernateSessionPractice {

	public static void main(String[] args) {
           HibernateSessionPractice hibernateSessionPractice = new HibernateSessionPractice();
           hibernateSessionPractice.operations();
	}

	private void operations() {
		//testingGetAndLoad();
		//testingSessionMerge();
		//testSavingVsPerist();
		testSaving();
	}
	
	private void testSaving() {
		Student student ;
		Transaction transaction;
		try(SessionUtils sessionUtils = new SessionUtils()){
			Session session = sessionUtils.getSession();
			transaction = session.beginTransaction();
			student = getStudentSampleData();
			//int id = (int) session.save(student);
			session.persist(student);
			//System.out.println(" Student Record Save and new id is : "+id);
			System.out.println(" Ok Created ");
			student.setStudentName("updaeName2");
			//session.flush();
			transaction.commit();
		}catch(RuntimeException exp){
			exp.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Student getStudentSampleData() {
			Student student = new Student();
			Address address = new Address();
			student.setStudentName("Student with Address");
			student.setStudentClass(" Stuvatpuram");
			address.setCity("Stuvartuparam");
			address.setState("Ongole");
			student.setAddress(address);
			address.setStudent(student);
			
		return student;
	}

	public void testSavingVsPerist(){
		Student student ;
		try(SessionUtils sessionUtils = new SessionUtils()){
			Session  session = sessionUtils.getSession();
			Transaction transaction = session.beginTransaction();
			student =new Student();
			//student.setStudentId(9);
			student.setStudentName(" Java11");
			student.setStudentClass(" Infobrain 11 section");
			session.persist(student);
			System.out.println("\n Student Id is : "+student.getStudentId());
			transaction.commit();
		}catch(RuntimeException exp){
			exp.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testingSessionMerge(){
		Student student ;
		try(SessionUtils sessionUtils = new SessionUtils()){
			Session  session = sessionUtils.getSession();
			Transaction transaction = session.beginTransaction();
			student =new Student();
			//student.setStudentId(7);
			student.setStudentName(" Java8 Man33433");
			student.setStudentClass(" Info23283brain334333 ");
			session.merge(student);
			transaction.commit();
		}catch(RuntimeException exp){
			exp.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void testingGetAndLoad(){
		Customers customer = getCustomerDetail(123);
		System.out.println("\n Customer Object is Ready to Fire ");
		if(customer!=null){
			System.out.println("  Name is: "+customer.getCustomerName());
		}else{
			System.out.println("Customer Not Existed !");
		}
	}
public Customers getCustomerDetail(int serializeID){
		try(SessionUtils sessionUtils = new SessionUtils()){
			Session session = sessionUtils.getSession();
			return (Customers) session.get(Customers.class,serializeID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
