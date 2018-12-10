package com.thang.techshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.thang.techshop.model.Category;

public class CategoryDao {

	private static ArrayList<Category> dsCategory=new ArrayList<Category>();
	
	public static ArrayList<Category> getCategory()
	{
		dsCategory.clear();
		String sqlCmd="select * from category;";
		
		ResultSet rs=  ConnectDatabase.retrieveData(sqlCmd);

		
		try {
			while(rs.next())
			{
				Category category=new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategory(rs.getString(2));
				dsCategory.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsCategory;
		
	}
	
}
