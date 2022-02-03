package com.mahesh.angularjs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mahesh.angularjs.dao.FetchDAO;
import com.mahesh.angularjs.model.Contact;
import com.mahesh.angularjs.service.ContactService;

public class ContactServiceImpl implements ContactService
{
	 @Autowired
	    private FetchDAO fetchDAO;

	    @Override
	    @Transactional
	    public void addContact(Contact cont)
	    {
	    fetchDAO.addContact(cont);
	    }

	    @Override
	    @Transactional
	    public List<Contact> getAllContacts()
	    {
		return fetchDAO.getAllContacts();
	    }

	    @Override
	    @Transactional
	    public void deleteContact(Integer contactId) 
	    {
	    	fetchDAO.deleteContact(contactId);
	    }

	    public Contact getContact(int contactId) 
	    {
		return fetchDAO.getContact(contactId);
	    }

	    public Contact updateContact(Contact cont)
	    {
		return fetchDAO.updateContact(cont);
	    }

	    public void setFetchDAO(FetchDAO fetchDAO)
	    {
		this.fetchDAO = fetchDAO;
	    }		
}
