package com.practice.hibernate.testing;

import java.util.List;

import org.hibernate.Session;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.pojo.Customers;


public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.operations();
	}

	private  void operations() {
		readCustomersSampleData();
	}

	private void readCustomersSampleData() {
		List<Customers> customersList = getCustomerDetails();
		 for( Customers customer : customersList)
        {
     	   System.out.println(" Name is : "+customer.getContactFirstName());
        }
	}

	private List<Customers> getCustomerDetails() {
           Session session = HibernateUtil.getSession();
           try{
          // session.beginTransaction();
           return session.createCriteria(Customers.class).list();	
          }catch(Exception ex){
        	   ex.printStackTrace();
           }finally{
        	   session.clear();
        	   session.close();
           }
		return null;
           
	}
}
