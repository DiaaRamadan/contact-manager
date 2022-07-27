package com.spring.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.contact.model.Contact;

class ContactDaoTest {

	private DriverManagerDataSource dataSource;
	private ContactDao contactDao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3366/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("P@ssword");
		contactDao = new ContactDaoImp(dataSource);
	}

	@Test
	void testSave() {
		var contact = new Contact("User1", "user@mail.com", "Cairo, egypt", "01245398574");
		int result = contactDao.save(contact);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		var contact = new Contact(1, "User2", "user2@mail.com", "Cairo2, egypt", "01245398572");
		int result = contactDao.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		var result = contactDao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		var contact = contactDao.get(id);
		assertNotNull(contact);
	}

	@Test
	void testList() {
		var contacts = contactDao.list();
		assertTrue(!contacts.isEmpty());
	}

}
