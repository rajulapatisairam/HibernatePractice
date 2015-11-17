package com.practice.hibernate.testing.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.Customers;

public class CriteriaTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriteriaTesting CriteriaTesting_obj = new CriteriaTesting();
		CriteriaTesting_obj.operations();
	}

	private void operations() {
		//restrictions();
		//projectionExample();
		//aggrigrateFunctions();
		//orderByExample();
		//orderAndGroupExample();
		queryByExample();
	}

	private void queryByExample() {
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				Customers customerr = new Customers();
				customerr.setCountry("Australia");
				customerr.setCustomerName("A%");
				Example example = Example.create(customerr);
				Criteria criteria = session.createCriteria(Customers.class);
				criteria.add(example);
				example.enableLike();
				example.excludeProperty("city");
				List<Customers> customers = criteria.list();
				for(Customers customer : customers){
					System.out.println(" Name :"+customer.getCustomerName()+" "
							+ "	country is : "+customer.getCountry()+"  City : "+customer.getCity());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Query By Examole s Operation is COmpleted!...");
			}
	}

	private void orderAndGroupExample() {
			
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
					Criteria criteria = session.createCriteria(Customers.class);
					criteria.addOrder(Order.desc("creditLimit"));
					criteria.setProjection(Projections.groupProperty("country"));
					List<Object> list = criteria.list();
					for(Object object : list){
						System.out.println("\n Country is : "+object);
					}
					/*List<Customers> customers = criteria.list();
					for(Customers customer : customers){
						System.out.println(" name is ; "+customer.getCustomerName()+" country is : "+customer.getCountry()+" Credit Limit is: "+customer.getCreditLimit());
					}*/
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Order by grouping    Operation is COmpleted!...");
			}
	}

	private void orderByExample() {
		
		Transaction transaction ;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			Criteria criteria = session.createCriteria(Customers.class);
			criteria.addOrder(Order.desc("creditLimit"));
			List<Customers> customers = criteria.list();
			for( Customers customer : customers){
			System.out.println("\n Name is: "+customer.getCustomerName()+" Credit Limit is: "+customer.getCreditLimit());	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Order by example   Operation is COmpleted!...");
		}
	}

	private void aggrigrateFunctions() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			// Row Count 
			Criteria criteria = session.createCriteria(Customers.class);
			 criteria.setProjection(Projections.rowCount());
			 System.out.println("\n Row Count is "+criteria.uniqueResult());
			 criteria.setProjection(Projections.sum("creditLimit"));
			 System.out.println("\n Cridit Limit Sums is : "+criteria.uniqueResult());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Aggrigrate Functions Operation is COmpleted!...");
		}
	}

	private void projectionExample() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			Criteria criteria = session.createCriteria(Customers.class);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("customerName"));
			projectionList.add(Projections.property("phone"));
			criteria.setProjection(projectionList);
			List<Object[]> names = criteria.list();
			for( Object name[] : names){
				System.out.println(" \n Name is: "+name[0]+" Numberis : "+name[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Projections Exmaple   Operation is COmpleted!...");
		}
	}

	private void restrictions() {
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				Criteria criteria = session.createCriteria(Customers.class);
				Criterion criterion = Restrictions.like("customerName", "%a%");
				Criterion criterion2 = Restrictions.ne("customerName", "Diecast Collectables");
				criteria.add(criterion);
				criteria.add(criterion2);
				List<Customers> customers = criteria.list();
				
				for(Customers customer : customers){
					System.out.println(" name is : "+customer.getCustomerName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Citerai ReadOperation   Operation is COmpleted!...");
			}
	}

}
