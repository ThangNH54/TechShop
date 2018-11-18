package com.thang.techshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.techshop.dao.CustomerDao;
import com.thang.techshop.model.Customer;

/**
 * Servlet implementation class UploadAvatarController
 */
@WebServlet("/UploadAvatarController")
public class UploadAvatarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAvatarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("account");
		String oldPath=customer.getUrlAvatar();
			if((boolean)(request.getAttribute("checkUploadFile"))==true)//tai file len thanh cong, update database customer
			{
				customer.setUrlAvatar((String)request.getAttribute("path"));
				if(CustomerDao.updateCustomer(customer, 10))
				{
					request.setAttribute("msg", "Upload Avatar Thành Công.");
					session.setAttribute("account", customer);
					request.getRequestDispatcher("editInfoCustomerView").forward(request, response);
				}
				else
				{
					customer.setUrlAvatar(oldPath);
					request.setAttribute("msg", "Upload Avatar Thất bại.");
					request.getRequestDispatcher("editInfoCustomerView").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Upload Avatar Thất bại.");
				request.getRequestDispatcher("editInfoCustomerView").forward(request, response);
			}
		
		
	}

}
