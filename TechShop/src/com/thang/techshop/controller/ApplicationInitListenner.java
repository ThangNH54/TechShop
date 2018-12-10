package com.thang.techshop.controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.thang.techshop.dao.CategoryDao;
import com.thang.techshop.dao.ConnectDatabase;
import com.thang.techshop.dao.ProductDao;
import com.thang.techshop.model.Category;
import com.thang.techshop.model.Product;

public class ApplicationInitListenner implements ServletContextListener {
	
	//The ServletContextEvent is notified when web application is deployed on the server
	//must register in web.xml
	//ex: connection database,...
	
	public void contextInitialized(ServletContextEvent event) 
	{
		//code to initialize the database connection
		//and store it as a context attribute
		ServletContext context=event.getServletContext();
		//String str=context.getInitParameter("ContextParam");
		//context.setAttribute("ContextParam", str);
		
		ConnectDatabase.setDriver(context.getInitParameter("driver"));
		ConnectDatabase.setUrl("jdbc:mysql://localhost:3306/firstshop?autoReconnect=true&useSSL=false");
		ConnectDatabase.setUser(context.getInitParameter("user"));
		ConnectDatabase.setPassword(context.getInitParameter("password"));
		
		if(ConnectDatabase.initialize(0))
		{
			context.setAttribute("connection", ConnectDatabase.getConnection());
			//lay danh sach san pham
			ArrayList<Category> dsCategory=CategoryDao.getCategory();
			context.setAttribute("category", dsCategory);
		}
		
		
	}
	
	public void contextDestroyed(ServletContextEvent event) 
	{
		//code to close the database connection
		ServletContext context=event.getServletContext();
		try 
		{
			Connection conn=(Connection)context.getAttribute("connection");
			conn.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

}
