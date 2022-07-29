package com.spring.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.RowData;
import com.spring.contact.model.Contact;


public class ContactDaoImp implements ContactDao {

	private JdbcTemplate jdbcTemplate;

	public ContactDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact contact) {
		String sql = "INSERT INTO contacts (name, email, address, phone) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(),
				contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE contacts SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(),
				contact.getId());
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contacts WHERE contact_id= " + id;
		return jdbcTemplate.update(sql);

	}

	@Override
	public Contact get(Integer id) {

		String sql = "SELECT * FROM contacts WHERE contact_id = " + id;

		ResultSetExtractor<Contact> extractor = rs -> {

			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Contact(id, name, email, address, phone);
			}

			return null;
		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contacts";
		RowMapper<Contact> mapper = (rs, rowNum) -> {
			Integer id = rs.getInt("contact_id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String phone = rs.getString("phone");
			;
			return new Contact(id, name, email, address, phone);
		};
		return jdbcTemplate.query(sql, mapper);
	}

}
