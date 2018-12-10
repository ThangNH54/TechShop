package com.thang.techshop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.thang.techshop.model.Category;
import com.thang.techshop.model.Product;

public class ProductDao {

private static ArrayList<Product> dsProduct=new ArrayList<Product>();
	
	public static ArrayList<Product> getProducts(int categoryId)//get by category
	{
		dsProduct.clear();
		String sqlCmd="select * from product where CategoryID='"+Integer.toString(categoryId)+"';";
		
		return getProducts(sqlCmd);
		
	}
	
	public static ArrayList<Product> getProducts(int categoryId,String hangSx)//get by category, hang sx
	{
		dsProduct.clear();
		String sqlCmd="select * from product where CategoryID='"+Integer.toString(categoryId)+"' and HangSX='"+hangSx+"';";
		
		return getProducts(sqlCmd);
		
	}
	
	public static ArrayList<Product> getProducts(String sqlCmd)
	{
		dsProduct.clear();
		
		ResultSet rs=  ConnectDatabase.retrieveData(sqlCmd);
		

		try {
			while(rs.next())
			{
				Product product=new Product();
				
				product.setiD(rs.getInt(1));
				product.setCategoryId(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setGiaBan(rs.getDouble(4));
				product.setSoLuong(rs.getInt(5));
				product.setHangSX(rs.getString(6));
				product.setLink(rs.getString(7));
				
				//lay chi tiet san pham
				
				sqlCmd="select * from chitietsanpham where ProductID='"+product.getiD()+"';";
				
				ResultSet rs2=  ConnectDatabase.retrieveData(sqlCmd);
				
				while(rs2.next())
				{
					product.setMoTa1(rs2.getString(3));
					product.setMoTa2(rs2.getString(4));
					product.setKhuyenMai(rs2.getString(5));
					
				}
				
				dsProduct.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsProduct;
		
	}
	
	
	

	public static ArrayList<Product> getProductsHot()//lay danh sach san pham hot
	{
		dsProduct.clear();
		String sqlCmd="select * from featureproduct;";
		
		ResultSet rs=  ConnectDatabase.retrieveData(sqlCmd);
		
		try {
			while(rs.next())
			{
				
				dsProduct.add(getProduct(rs.getInt(1)));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return dsProduct;	
	}
	
	public static Product getProduct(int productID)//lay 1 san pham
	{
		String sqlCmd="select * from product where ID='"+productID+"';";
		
		ResultSet rs=  ConnectDatabase.retrieveData(sqlCmd);
		
		Product product=new Product();
		
		try {
			while(rs.next())
			{
				product.setiD(rs.getInt(1));
				product.setCategoryId(2);
				product.setName(rs.getString(3));
				product.setGiaBan(rs.getDouble(4));
				product.setSoLuong(rs.getInt(5));
				product.setHangSX(rs.getString(6));
				product.setLink(rs.getString(7));
				
				//lay chi tiet san pham
				
				
				sqlCmd="select * from chitietsanpham where ProductID='"+product.getiD()+"';";
				
				ResultSet rs2=  ConnectDatabase.retrieveData(sqlCmd);
				
				while(rs2.next())
				{
					product.setMoTa1(rs2.getString(3));
					product.setMoTa2(rs2.getString(4));
					product.setKhuyenMai(rs2.getString(5));
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	
	
	
}
