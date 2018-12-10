package com.thang.techshop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.thang.techshop.dao.ConnectDatabase;
import com.thang.techshop.dao.CustomerDao;
import com.thang.techshop.model.Customer;

public class CustomerService {

	public static boolean register(Customer customer)
	{
		
		if(CustomerDao.insertCustomer(customer)) return true;
		else return false;
	}
	public static Customer authentication(String userName,String password)
	{
		Customer customer=CustomerDao.getCustomer(userName);
		if(customer!=null)
		{
			if(password.equals(customer.getPassword())) return customer;
		}
		return null;
	}
	
	public static int getCustomerID()
	{
		String sqlCmd="select count(ID) from account;";
		int count=0;
		ResultSet rs=ConnectDatabase.retrieveData(sqlCmd);
		try 
		{
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return count+1;
	}
}
