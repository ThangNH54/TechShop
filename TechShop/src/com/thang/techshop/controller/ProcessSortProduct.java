package com.thang.techshop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.techshop.model.Product;

/**
 * Servlet implementation class ProcessSortProduct
 */
public class ProcessSortProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessSortProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Product> dsProduct=(ArrayList<Product>)session.getAttribute("product");
		
		String sortBy=request.getParameter("sortBy");
		
		if(sortBy.equals("2"))//sap xep theo gia giam dan
		{
			ArrayList<Product> dsNewProduct=new ArrayList<Product>();
			
			for (int i=dsProduct.size()-1;i>=0;i--) {
				dsNewProduct.add(dsProduct.get(i));
			}
			
			session.setAttribute("product", dsNewProduct);
			request.getRequestDispatcher("accessoriesView").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("accessoriesView").forward(request, response);
		}
		
	}


}
