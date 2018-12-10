package com.thang.techshop.service;

import java.util.Comparator;

import com.thang.techshop.model.Product;

public class ProductComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		
		if(o1==null&&o2==null) return 0;
		else if(o1==null) return -1;
		else if(o2==null) return 1;
		else
		{
			double value=o1.getGiaBan()-o2.getGiaBan();
			if(value!=0) return (int) value;
			else
			{
				value=o1.getName().compareTo(o2.getName());
				return (int) value;
			}
		}
		
	}

}
