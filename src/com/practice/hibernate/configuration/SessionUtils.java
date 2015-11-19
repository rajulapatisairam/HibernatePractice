package com.practice.hibernate.configuration;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

public class SessionUtils implements AutoCloseable{
       Session session;
       StatelessSession statelessSession;

    public SessionUtils() {
        this.session = HibernateUtil.getSession();
        this.statelessSession = HibernateUtil.getStateLessSession();
	}

	public Session getSession() {
		return session;
	}
	
	public StatelessSession getStatelessSession() {
		return statelessSession;
	}

	@Override
	public void close() throws Exception {
		System.out.println("\n Clear The session!...");
	        if(this.session != null){
	        	this.session.clear();
	        	this.session.close();
	        }
	        if( this.statelessSession !=null){
	        	this.statelessSession.close();
	        }
	}
}
