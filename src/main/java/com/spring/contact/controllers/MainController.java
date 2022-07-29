package com.spring.contact.controllers;

import com.spring.contact.dao.ContactDao;
import com.spring.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private ContactDao contactDao;

	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("contacts", contactDao.list());
		return mv;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact() {
		ModelAndView mv = new ModelAndView("contact_form");
		mv.addObject("contact", new Contact());
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@Valid Contact contact, Errors errors) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("contact_form");
			mv.addObject("contact", contact);
			return mv;
		}
		contactDao.save(contact);
		return new ModelAndView("redirect:/");
	}
}
