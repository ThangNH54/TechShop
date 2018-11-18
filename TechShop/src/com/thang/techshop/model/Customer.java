package com.thang.techshop.model;

import com.thang.techshop.dao.CustomerDao;

public class Customer extends User{
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int iD, String userName, String email, String password, String firstName, String lastName,
			long phone, String addr, String sex, String urlAvatar) {
		super(iD, userName, email, password, firstName, lastName, phone, addr, sex, urlAvatar);
		// TODO Auto-generated constructor stub
	}

}
