package com.spring.contact.dao;

import java.util.List;

import com.spring.contact.model.Contact;

public interface ContactDao {

	public int save(Contact contact);

	public int update(Contact contact);

	public int delete(Integer id);

	public Contact get(Integer id);

	public List<Contact> list();
}
