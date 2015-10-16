package com.practice.hibernate.testing.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.mapping.onetoone.Table1;
import com.practice.hibernate.pojo.mapping.onetoone.Table2;

public class OneToOneTesting {

	public static void main(String[] args) {
		OneToOneTesting testing = new OneToOneTesting();
		//testing.writeOperations();
		testing.readOperation();
	}

	private void readOperation() {
		Transaction transaction;
		try(SessionUtils utils = new SessionUtils()){
			Session session = utils.getSession();
			Table1 table1 = (Table1) session.get(Table1.class, 1);
			Table2 table2 = table1.getTable2();
			System.out.println(" Table 1 value is :"+table1.getT1_field1()+" Field2 is : "+table1.getT1_field2());
			System.out.println(" Table 2 value is :"+table2.getT2_field2()+" Field2 is : "+table2.getT2_field2());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" One to ONe Reading Operation is COmpleted!...");
		}
	}

	private void writeOperations() {
		Transaction transaction;
		try(SessionUtils utils = new SessionUtils()){
			Session session = utils.getSession();
			transaction = session.beginTransaction();
			Table1 table1 = new Table1();
			Table2 table2 = new Table2();
			table1.setT1_field1("Field 3");
			table1.setT1_field2("Field 4");
			table2.setT2_field1("Field 5");
			table2.setT2_field2("Field 6");
			table1.setTable2(table2);
			table2.setTable1(table1);
			session.save(table1);
			session.save(table2);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			System.out.println(" One to One Completed !");
		}
	}
}
