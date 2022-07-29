package com.spring.contact.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Contact {

	private Integer id;

	@NotBlank(message = "Name Must Not Be Blank")
	private String name;

	@NotBlank(message = "Email Must Not Be Blank")
	@Email(message = "Enter Valid Email")
	private String email;

	@NotBlank(message = "Address Must Not Be Blank")
	private String address;

	@NotBlank(message = "Phone Must Not Be Blank")
	@Length(min = 11, max = 11, message = "Phone Number Must Be 11 Digits")
	private String phone;

	public Contact() {}


	public Contact(Integer id, String name, String email, String address, String phone) {
		this(name, email, address, phone);
		this.id = id;
	}

	public Contact(String name, String email, String address, String phone) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
				+ phone + "]";
	}
}
