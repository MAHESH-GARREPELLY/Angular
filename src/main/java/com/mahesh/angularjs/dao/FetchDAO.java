package com.mahesh.angularjs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
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

	
	
	
	public void insertRecord(String firstname,String middlename,String lastname,String  gender,String email,String phone,String address,String city,int pincode,byte profile) {
		System.out.println("INSERT A RECORD INTO DATABASE...........");
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
			
			tx.commit();
			
			
			
		}catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			
		}
		return conArrList;
	}
	
	// rajendra method
	
	
	public void testMethod()
	{
		System.out.println("git test");
	}	
	
	//update method for record
	
	public void updateRecord(Integer id,String firstname, String middlename,String lastname,String gender,String email,String phone,String address,String city,int pincode,byte profile) {
		
		getFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			String sql="Update test.Contact set firstname='"+firstname+"',middlename='"+middlename+"',lastname='"+lastname+"',gender='"+gender+"',email='"+email+"',phone='"+phone+"',address='"+address+"',city='"+city+"',pincode='"+pincode+"',profile='"+profile+"'";
			
			System.out.println("update sql statement is "+sql);
			SQLQuery query=session.createSQLQuery(sql);
			query.executeUpdate();
			tx.commit();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null) tx.rollback();
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		
	}
	
	
	
	public void deleteRecord() {
		
		
		getFactory();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
