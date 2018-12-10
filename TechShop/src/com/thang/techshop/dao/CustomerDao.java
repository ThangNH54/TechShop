package com.thang.techshop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.protocol.Resultset;

import com.thang.techshop.model.Customer;

public class CustomerDao {
	
	//lay thong tin 1 khach hang
	public static Customer getCustomer(String key)//key la id , email or username
	{
		Customer customer=null;
		String sqlCommand="Select * from account where ID='"+key+"' or UserName='"+key+"' or email='"+key+"';";
		ResultSet rs=ConnectDatabase.retrieveData(sqlCommand);
		if(rs!=null)
		{
			try {
				while(rs.next())
				{
					customer=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getString(9), rs.getString(10));
				}
			} catch (SQLException e) {
				customer=null;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	//lay thong tin nhieu khach hang
	public static ArrayList<Customer> getCustomers()
	{
		ArrayList<Customer> dsCustomer=new ArrayList<Customer>();
		Customer customer=null;
		String sqlCommand="select * from account;";
		ResultSet rs=ConnectDatabase.retrieveData(sqlCommand);
		if(rs!=null)
		{
			try {
				while(rs.next())
				{
					customer=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getLong(7), rs.getString(8), rs.getString(9), rs.getString(10));
					if(customer!=null)
					{
						dsCustomer.add(customer);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dsCustomer;
	}
	
	//lay danh sach id cua khach hang
	public static ArrayList getCustomerIDs()
	{
		ArrayList dsID=new ArrayList<>();
		
		String sqlCmd="select ID from account ;";
		
		ResultSet rs=ConnectDatabase.retrieveData(sqlCmd);
		if(rs!=null)
		{
			try {
				while(rs.next())
				{
					dsID.add(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dsID;
		
	}
	
	//them khach hang
	public static boolean insertCustomer(Customer tmp)
	{
		try {

			String sqlCommand="insert into account(`ID`, `UserName`, `Email`, `Password`, `FirstName`, `LastName`,`Phone`,`Addr`,`Sex`,`UrlAvatar`,`isAdmin`) value(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt=ConnectDatabase.getConnection().prepareStatement(sqlCommand);
			stmt.setInt(1, tmp.getiD());
			stmt.setString(2, tmp.getUserName());
			stmt.setString(3, tmp.getEmail());
			stmt.setString(4, tmp.getPassword());
			stmt.setString(5, tmp.getFirstName());
			stmt.setString(6, tmp.getLastName());
			stmt.setLong(7, tmp.getPhone());
			stmt.setString(8, tmp.getAddr());
			stmt.setString(9, tmp.getSex());
			stmt.setString(10, tmp.getUrlAvatar());
			stmt.setBoolean(11,false);
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	//xoa khach hang
	public static boolean deleteCustomer(int id)
	{
		String sqlCmd="delete from account where ID='"+id+"';";
		try {
			PreparedStatement stmt=ConnectDatabase.getConnection().prepareStatement(sqlCmd);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
		
	}
	
	public static boolean updateCustomer(Customer customer,int index)
	{
		String sqlCmd="update account set ";
		
		switch (index) {
			case 4:
			{
				sqlCmd+="Password='"+customer.getPassword()+"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 5:
			{
				sqlCmd+="FirstName='"+customer.getFirstName()+"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 6:
			{
				sqlCmd+="LastName='"+customer.getLastName()+"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 7:
			{
				sqlCmd+="Phone='"+Long.toString(customer.getPhone()) +"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 8:
			{
				sqlCmd+="Addr='"+customer.getAddr()+"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 9:
			{
				sqlCmd+="Sex='"+customer.getSex()+"' where ID='"+customer.getiD()+"';";
				break;
			}
			
			case 10:
			{
				sqlCmd+="UrlAvatar='"+customer.getUrlAvatar()+"' where ID='"+customer.getiD()+"';";
				break;
			}
				
	
			default:
				break;
			}
		
		try {
			
			PreparedStatement stmt=ConnectDatabase.getConnection().prepareStatement(sqlCmd);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
		
	}

}
