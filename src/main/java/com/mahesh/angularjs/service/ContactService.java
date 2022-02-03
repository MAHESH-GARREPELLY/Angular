package com.mahesh.angularjs.service;

import java.util.List;
import com.mahesh.angularjs.model.Contact;
public interface ContactService 
{
	public void addContact(Contact Cont);
	 
    public List<Contact> getAllContacts();
 
    public void deleteContact(Integer contactId);
 
    public Contact getContact(int contactid);
 
    public Contact updateContact(Contact cont);
}
