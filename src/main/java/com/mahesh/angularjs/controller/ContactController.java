package com.mahesh.angularjs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.angularjs.service.ContactService;
import com.mahesh.angularjs.model.Contact;


public class ContactController 
{
	  @Autowired
	    private ContactService contactService;
	    
	    @RequestMapping(value = {"", "/", "home"})
	    public ModelAndView listContact(ModelAndView model) throws IOException {
	    	List<Contact> listContact = contactService.getAllContacts();
	    	model.addObject("listContact", listContact);
	    	model.setViewName("home");
	    	return model;
	    }

	    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
	    public ModelAndView newContact(ModelAndView model) {
	    	Contact cont = new Contact();
	    	model.addObject("contact", cont);
	    	model.setViewName("contact-form");
	    	return model;
	    }

	    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	    public ModelAndView saveContact(@ModelAttribute("contact") Contact cont) {
	        if (cont.getId() == 0) { 
	        	contactService.addContact(cont);
	    	} else {
	    		contactService.updateContact(cont);
	    	}
	    	return new ModelAndView("redirect:/");
	    }

	    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	    public ModelAndView deleteContact(HttpServletRequest request) {
	        int contactId = Integer.parseInt(request.getParameter("id"));
	        contactService.deleteContact(contactId);
	        return new ModelAndView("redirect:/");
	    }

	    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	        int contactId = Integer.parseInt(request.getParameter("id"));
	        Contact cont = contactService.getContact(contactId);
	        ModelAndView model = new ModelAndView("contact-form");
	        model.addObject("contact", cont);

	    	return model;
	    }
}
