package com.practice.hibernate.testing.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.pojo.Customers;


public class HQLTesting {

	public static void main(String[] args) {
           HQLTesting hqlTesting = new HQLTesting();
           hqlTesting.executeData();
	}

	private void executeData() {
	    // readSampleData();
	     selectClause();
	}

	private void selectClause() {
		  Session session = HibernateUtil.getSession();
		  try{
          String hql = " SELECT customerNumber,customerName FROM customers ";
          Query query = session.createQuery(hql);
          List<Object[]> customersList =  query.list();
          for( Object[] customer : customersList){
        	  System.out.println(" Customer Name is : "+customer[0]+" Name is :"+customer[1]);
          }
		  }catch(Exception exp){
			  System.out.println(" Error is  : "+exp.getMessage());
			  exp.printStackTrace();
		  }finally{
			  session.close();
			  System.out.println("\n Reading is finished in Select Clause ");
		  }
	}

	private void readSampleData() {
		
		  Session session = HibernateUtil.getSession();
		  try{
          String hql = " FROM customers ";
          Query query = session.createQuery(hql);
          List<Customers> customersList =  query.list();
          for( Customers customer : customersList){
        	  System.out.println(" Customer Name is : "+customer.getCustomerName()+" Credit Limit  "+customer.getCreditLimit());
          }
		  }catch(Exception exp){
			  System.out.println(" Error is  : "+exp.getMessage());
		  }
	}

}
