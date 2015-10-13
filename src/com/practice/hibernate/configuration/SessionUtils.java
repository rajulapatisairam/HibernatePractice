package com.practice.hibernate.configuration;

import org.hibernate.Session;

public class SessionUtils implements AutoCloseable{
       Session session;

    public SessionUtils() {
        this.session = HibernateUtil.getSession();
	}

	public Session getSession() {
		return session;
	}

	@Override
	public void close() throws Exception {
		System.out.println("\n Clear The session!...");
	        if(this.session != null){
	        	this.session.clear();
	        	this.session.close();
	        }
	}
}
