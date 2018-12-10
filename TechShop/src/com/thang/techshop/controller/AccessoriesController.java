package com.thang.techshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.techshop.dao.ProductDao;
import com.thang.techshop.model.Category;
import com.thang.techshop.model.Product;
import com.thang.techshop.service.ProductComparator;

/**
 * Servlet implementation class AccessoriesController
 */
@WebServlet("/AccessoriesController")
public class AccessoriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessoriesController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String category=request.getParameter("sp");
		String hangSx=request.getParameter("hangSx");
		if(hangSx==null) hangSx="null";
		
		ArrayList<Category> dsCategory=(ArrayList<Category>) getServletContext().getAttribute("category");
		
		if(category.equals("mt"))//lay danh sach tat ca may tinh
		{
			ArrayList<Product> dsProduct = new ArrayList<Product>();
			for(Category i: dsCategory)
			{
				if(i.getCategory().equals("PC")||i.getCategory().equals("Laptop"))//loc loai san pham
				{
					//lay danh sach san pham tuong ung
					dsProduct.addAll(ProductDao.getProducts(i.getCategoryId()));

				}
			}
			Collections.sort(dsProduct,new ProductComparator());
			session.setAttribute("product", dsProduct);
			request.getRequestDispatcher("accessoriesView").forward(request, response);
		}
		
		else
		{
			for(Category i: dsCategory)//lay danh sach san pham theo loai san pham
			{
				if(i.getCategory().equals(category))//loc loai san pham
				{
					ArrayList<Product> dsProduct=null;
					if(hangSx.equals("null"))
					{
						//lay danh sach san pham tuong ung theo category
						dsProduct=ProductDao.getProducts(i.getCategoryId());
					}
					else
					{
						//lay danh sach san pham tuong ung theo category va hang sx
						dsProduct=ProductDao.getProducts(i.getCategoryId(),hangSx);
					}
					
					Collections.sort(dsProduct,new ProductComparator());
					session.setAttribute("product", dsProduct);
					request.getRequestDispatcher("accessoriesView").forward(request, response);
					break;
				}
			}
		}
		
		
	}


}
