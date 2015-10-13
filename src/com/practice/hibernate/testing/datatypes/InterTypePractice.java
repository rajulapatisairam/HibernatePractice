package com.practice.hibernate.testing.datatypes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.hibernate.configuration.HibernateUtil;
import com.practice.hibernate.pojo.datatypes.IntClass;

public class InterTypePractice {

	public static void main(String[] args) {
		InterTypePractice object = new InterTypePractice();
		object.dbOperations();
	}

	private void dbOperations() {
		//wirteSampleData();
		int primarykey = 12;
		int updateValue =27;
		//updateRecords(primarykey, updateValue);
		//deleteRecord(primarykey);

	}

	private void deleteRecord(int primarykey) {
		 Session session = HibernateUtil.getSession();
         Transaction transaction = session.beginTransaction();
         try{
        	 IntClass intClass = (IntClass) session.get(IntClass.class, primarykey);
        	 if( intClass != null){
        	 session.delete(intClass);
        	 }
        	 transaction.commit();
         }catch(HibernateException exp){
        	 exp.printStackTrace();
         }catch(Exception exp){
        	 exp.printStackTrace();
         }
         finally{
        	 session.close();
        	 System.out.println(" Deletion Completed !");
         }
	}

	private  void updateRecords(int primarykey, int updateValue) {
		 Session session = HibernateUtil.getSession();
         Transaction transaction = session.beginTransaction();
         try{
        	 IntClass intClass = (IntClass) session.get(IntClass.class, primarykey);
        	 if( intClass != null){
        	 intClass.setDefaultValue(updateValue);
        	 session.update(intClass);
        	 }
        	 transaction.commit();
         }catch(HibernateException exp){
        	 exp.printStackTrace();
         }catch(Exception exp){
        	 exp.printStackTrace();
         }
         finally{
        	 session.close();
        	 System.out.println(" Updation Completed !");
         }
	}

	private void wirteSampleData() {
         IntClass intClass = getSampleData();	
         writeToDataBase(intClass);
         System.out.println("\n Wite Successfully");
         intClass.setDefaultValue(88);
	}

	private void writeToDataBase(IntClass intClass) {
          Session session = HibernateUtil.getSession();
          Transaction transaction = session.beginTransaction();
          try{
        	  transaction.begin();
        	  session.save(intClass);
        	  transaction.commit();
        	  return;
          }catch( Exception exp){
        	  exp.printStackTrace();
          }
          finally{
		        	session.clear();
		        	session.close();
          }
	}

	private IntClass getSampleData() {
		IntClass intClass = new IntClass();
		intClass.setLength1(999);
		//intClass.setNotEmpty(9);
		intClass.setUnSign(20);
		return intClass;
		
	}

}
