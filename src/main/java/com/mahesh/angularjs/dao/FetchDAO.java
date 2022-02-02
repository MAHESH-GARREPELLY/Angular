package com.mahesh.angularjs.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.service.ServiceRegistry;

import com.mahesh.angularjs.model.Contact;

public class FetchDAO {
	
	public static SessionFactory factory;
	public static void getFactory() {
		try {
			
			Configuration configuration=new Configuration();
			configuration.addAnnotatedClass(Contact.class);
			configuration.configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			factory=configuration.buildSessionFactory(registry);
				
		}catch (Exception e) {
			// TODO: handle exception
		}	
	   }

	
	
	
	public void insertRecord() {
		System.out.println("INSERT A RECORD...........");
		getFactory();
		  Session session=factory.openSession();
		  
		  Transaction tx=null;
		  try {
			  tx=session.beginTransaction();
			  session.save(new Contact());
			  tx.commit();
			  
			  
			  
		  
		
	}catch (Exception e) {
		// TODO: handle exception
		if(tx!=null) tx.rollback();
		e.printStackTrace();
	}finally {
		session.close();
	}
	}
	
	
	public ArrayList<Contact> getAllRows() {
		getFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		ArrayList<Contact> conArrList=new ArrayList<Contact>();
		try {
			
			tx=session.beginTransaction();
			String sql="SELECT * from Contact";
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(Contact.class);
			List<Contact> contactDetailsList=query.list();
			for(Iterator iterator=contactDetailsList.iterator(); iterator.hasNext();) {
			
			Contact contactObject=(Contact) iterator.next();
			contactDetailsList.add(contactObject);
			
			
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
