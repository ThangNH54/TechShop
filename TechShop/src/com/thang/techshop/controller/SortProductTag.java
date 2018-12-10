package com.thang.techshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.thang.techshop.model.Product;
import com.thang.techshop.service.ProductComparator;

public class SortProductTag extends SimpleTagSupport{

	private ArrayList<Product> dsProduct=new ArrayList<Product>();

	public ArrayList<Product> getDsProduct() {
		return dsProduct;
	}

	public void setDsProduct(ArrayList<Product> dsProduct) {
		this.dsProduct = dsProduct;
	}
	
	public void doTag()throws JspException, IOException 
	{
		Collections.sort(dsProduct,new ProductComparator());
		
		PageContext pageContext = (PageContext) getJspContext();
	    JspWriter out = pageContext.getOut();
	    
		
	}
}
