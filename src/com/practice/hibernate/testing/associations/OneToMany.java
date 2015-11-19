/**
 * 
 */
package com.practice.hibernate.testing.associations;

import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.associations.Customer;
import com.practice.hibernate.pojo.associations.Vendor;

/**
 * @author Sairam Rajulapati
 *
 */
public class OneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneToMany OneToMany_obj = new OneToMany();
		OneToMany_obj.operations();
	}

	private void operations() {
		testingLazyLoading();
		//insertionOperations();
		//insertionOperationsWithStateLessSession();
		//readOperation();
		//deleteOperation();
	}

	private void testingLazyLoading() {
			
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				//StatelessSession session = utils.getStatelessSession();
				Vendor vendor = (Vendor) session.get(Vendor.class, 5);
				//session.evict(vendor);
				System.out.println("\n Vendor is : "+vendor.getVendorId()+" Vendor nme is: "+vendor.getVendorName());
				for ( Customer customer : vendor.getCustomers() ){
					System.out.println(" \n Customer Namei : "+customer.getCustomerName()+" Address is : "+customer.getCustomerAddress());
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Lazy Loading Testing...Operation is COmpleted!...");
			}
	}

	private void insertionOperationsWithStateLessSession() {
			
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				//Session session = utils.getSession();
				StatelessSession session = utils.getStatelessSession();
				transaction = session.beginTransaction();
	             Vendor vendor = new Vendor();
	             vendor.setVendorName("V2");
	             vendor.setVendorAdd("nuvvu nakina palem2");
	             
	             Customer customer2 =new Customer();
	             Customer customer1 = new Customer();
	             customer1=new Customer();
	             customer1.setCustomerName("c1");
	             customer1.setCustomerAddress("vadali");
	             
	             customer2.setCustomerName("c2");
	             customer2.setCustomerAddress("vadali2");
	             vendor.getCustomers().add(customer2);
	             vendor.getCustomers().add(customer1);
	             session.insert(vendor);
	             customer1.setVendor(vendor);
	             customer2.setVendor(vendor);
	             session.insert(customer1);
	             session.insert(customer2);
	             transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Insertion With OUt Child   Operation is COmpleted!...");
			}
	}

	private void deleteOperation() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			//StatelessSession session = utils.getStatelessSession();
			Vendor vendor = (Vendor) session.get(Vendor.class, 3);
			transaction = session.beginTransaction();
			session.delete(vendor);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Delete Operation is COmpleted!...");
		}
	}

	private void readOperation() {
		readVendor();
		readCustomer();
	}
	private void readCustomer() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			//Session session = utils.getSession();
			StatelessSession session = utils.getStatelessSession();
			Customer customer = (Customer) session.get(Customer.class, 2);
			System.out.println(" \n Customer Namei : "+customer.getCustomerName()+" Address is : "+customer.getCustomerAddress()+" Vendor Name is: "+customer.getVendor().getVendorName());
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Read Customer   Operation is COmpleted!...");
		}
	}

	private void readVendor(){  
			Transaction transaction;
			try (SessionUtils utils = new SessionUtils()) {
				Session session = utils.getSession();
				Vendor vendor = (Vendor) session.load(Vendor.class, 2);
				System.out.println("\n Vendor is : "+vendor.getVendorId()+" Vendor nme is: "+vendor.getVendorName());
				for ( Customer customer : vendor.getCustomers() ){
					System.out.println(" \n Customer Namei : "+customer.getCustomerName()+" Address is : "+customer.getCustomerAddress());
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("ReadOperation    Operation is COmpleted!...");
			}
	}

	private void insertionOperations() {
		
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			transaction = session.beginTransaction();
             Vendor vendor = new Vendor();
             vendor.setVendorName("V2");
             vendor.setVendorAdd("nuvvu nakina palem2");
             
             Customer customer2 =new Customer();
             Customer customer1 = new Customer();
             customer1=new Customer();
             customer1.setCustomerName("c1");
             customer1.setCustomerAddress("vadali");
             
             customer2.setCustomerName("c2");
             customer2.setCustomerAddress("vadali2");
             vendor.getCustomers().add(customer2);
             vendor.getCustomers().add(customer1);
             
             session.save(vendor);
             customer1.setVendor(vendor);
             customer2.setVendor(vendor);
             session.save(customer1);
             session.save(customer2);
             transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Insertion Operation is COmpleted!...");
		}
	}

}
