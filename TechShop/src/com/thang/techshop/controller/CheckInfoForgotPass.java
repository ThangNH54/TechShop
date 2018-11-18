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
import com.thang.techshop.util.CreateHashCode;
import com.thang.techshop.util.SendMail;

/**
 * Servlet implementation class CheckInfoForgotPass
 */
@WebServlet("/CheckInfoForgotPass")
public class CheckInfoForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInfoForgotPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		Customer customer=CustomerDao.getCustomer(userName);
		if(customer!=null)
		{
			//gui mail xac thuc
			String code=CreateHashCode.getCode();
			String content="Ma Xac Thuc Tai Khoan La : "+code+".";
			if(SendMail.send(request.getServletContext().getInitParameter("mailshop"), request.getServletContext().getInitParameter("passmailshop"), customer.getEmail(), "Shop-Confirm Email", content)==true)
			{
				HttpSession session=request.getSession();
				session.setAttribute("code", code);
				session.setAttribute("accountForgotPass", customer);
				session.setAttribute("email", customer.getEmail());
				session.setAttribute("action", "forgotPass");
				session.setAttribute("waitVeritifiCode", true);
				request.getRequestDispatcher("confirmEmailView").forward(request, response);
			}
			
		}
		else
		{
			request.setAttribute("msg", "Tài Khoản Không Tồn Tại.");
			request.getRequestDispatcher("forgotPassView").forward(request, response);
		}
	}

}
