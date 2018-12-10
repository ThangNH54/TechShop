package com.thang.techshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thang.techshop.dao.ProductDao;
import com.thang.techshop.model.Product;

/**
 * Servlet implementation class DetailsController
 */
@WebServlet("/DetailsController")
public class DetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID=Integer.parseInt(request.getParameter("sp"));
		
		Product product=ProductDao.getProduct(productID);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("detailsView.jsp").forward(request, response);
	}



}
