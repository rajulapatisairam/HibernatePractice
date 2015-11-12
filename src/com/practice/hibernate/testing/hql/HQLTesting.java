package com.practice.hibernate.testing.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.Address;
import com.practice.hibernate.pojo.Customers;


public class HQLTesting {

	public static void main(String[] args) {
           HQLTesting hqlTesting = new HQLTesting();
           hqlTesting.executeData();
	}

	private void executeData() {
	    // readSampleData();
	    //selectClause();
		//listVsIterator();
		//hqlCrudOperations();
		//uniqueResults();
		//positionAndNamedParametersInSingleQuery();
		aggregateMethods();
		
	}

	private void aggregateMethods() {
			
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				String queryString = "SELECT COUNT(*) FROM Customers";
				Query query = session.createQuery(queryString);
				query.setMaxResults(1);
				System.out.println(" Coustomer Count is : "+query.uniqueResult());
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Aggrigrate Method is Operation is COmpleted!...");
			}
	}

	private void positionAndNamedParametersInSingleQuery() {
			// 1st should positional parameter then after Named parameters....
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				String hql = " SELECT customerNumber,customerName FROM Customers WHERE "
						+ "customerNumber=? AND  city=? AND contactFirstName"
						+ "=:firstName AND state=:state  ";
				Query query = session.createQuery(hql);
				query.setParameter("firstName", "Carine");
				query.setString(0, "103");
				query.setParameter("state", "AndhraPradesh");
				query.setString(1, "Nantes");
				
				
				query.setMaxResults(1);
				
				Object[] customer = (Object[]) query.uniqueResult();
				System.out.println(" Customer Name is : "+customer[0]+" Name is :"+customer[1]);
				  
		          
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("operation   Operation is COmpleted!...");
			}
	}

	private void uniqueResults() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			String hql = " FROM Customers ";
			Query query = session.createQuery(hql);
			query.setMaxResults(1);
			  Customers customer = (Customers) query.uniqueResult();
        	  System.out.println(" Customer Name is : "+customer.getCustomerName()+" Credit Limit  "+customer.getCreditLimit());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("operation   Operation is COmpleted!...");
		}
	}

	private void hqlCrudOperations() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			transaction = session.beginTransaction();
			Address address = new Address();
			// Update 
			String updateQuery = "UPDATE Address SET state=:state WHERE city = :city";
			Query query =session.createQuery(updateQuery);
			// Named Parameters....
			query.setString("state", "Kamamm");
			query.setString("city","Stuvartuparam");
			int count= query.executeUpdate();
			System.out.println("\n Updae count is : "+count);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("operation   Operation is COmpleted!...");
		}	
	}

	private void listVsIterator() {
	
	Transaction transaction;
	try (SessionUtils utils = new SessionUtils()) {
		Session session = utils.getSession();
		  String hql = " SELECT customerNumber,customerName FROM Customers ";
		  
          Query query = session.createQuery(hql);
          query.setMaxResults(10);
           
          /*List<Customers> customersList =  query.list();
          for( Customers customer : customersList){
        	  System.out.println(" Customer Name is : "+customer.getCustomerName()+" Credit Limit  "+customer.getCreditLimit());
          }*/
          System.out.println("\n Iterator Example ...");
          Iterator<Object[]> iterator = query.iterate();
          while(iterator.hasNext()){
        	  Object[] customer =  iterator.next();
        	  System.out.println(" Customer Name is : "+customer[0]);//+" Credit Limit  "+customer.getCreditLimit());
          }
          
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		System.out.println("List Vs Iterator Method    Operation is COmpleted!...");
	}
	}

	private void selectClause() {
		  Session session = HibernateUtil.getSession();
		  try{
          String hql = " SELECT customerNumber,customerName FROM Customers ";
          Query query = session.createQuery(hql);
          query.setFirstResult(10);
          query.setMaxResults(10);
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
          String hql = " FROM Customers ";
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
