package com.practice.hibernate.testing.mapping;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.SessionUtils;
import com.practice.hibernate.pojo.mapping.Many2One1;
import com.practice.hibernate.pojo.mapping.ManyToOne2;
import com.practice.hibernate.testing.Operations;

public class ManyToOneTesting implements Operations{

	public static void main(String[] args) {
		ManyToOneTesting testing = new ManyToOneTesting();
		//testing.writeOperation();
		testing.readOperation();
	}

	@Override
	public void readOperation() {
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			ManyToOne2 ManyToOne2_obj =(ManyToOne2) session.get(ManyToOne2.class, 1);
			Many2One1 many2One1 = ManyToOne2_obj.getMany2One1();
			System.out.println(" Super Class Column 1 "+ManyToOne2_obj.getColumn1());
			System.out.println(" Super Class Column 2 "+ManyToOne2_obj.getColumn2());
			System.out.println(" Sub Class Column 1 "+many2One1.getColumn1());
			System.out.println(" Sub Class Column 2 "+many2One1.getColumn2());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(" Reading...  Operation is COmpleted!...");
		}
	}

	@Override
	public void writeOperation() {
		Transaction transaction;
		try (SessionUtils utils = new SessionUtils()) {
			Session session = utils.getSession();
			transaction = session.beginTransaction();
			ManyToOne2 ManyToOne2_obj = new ManyToOne2();
			Many2One1 Many2One1_obj = new Many2One1();
			ManyToOne2_obj.setColumn1("COlumnu 9");
			ManyToOne2_obj.setColumn2("COlumnu 10");
			Many2One1_obj.setColumn1("COlumnu 11");
			Many2One1_obj.setColumn2("COlumnu 12");
			ManyToOne2_obj.setMany2One1(Many2One1_obj);
			//session.save(Many2One1_obj);
			session.save(ManyToOne2_obj);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(" Writing Operation is COmpleted!...");
		}
	}
}
