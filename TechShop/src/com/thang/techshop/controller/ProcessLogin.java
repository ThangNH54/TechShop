package com.thang.techshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.techshop.model.Customer;
import com.thang.techshop.service.CustomerService;

/**
 * Servlet implementation class LoginController
 */
public class ProcessLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		Customer customer=CustomerService.authentication(userName, password);

		if(customer!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("account", customer);
			String msg="You are logged in! ";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("accountInfoView.jsp").forward(request, response);

		}
		else
		{
			String msg="Tên Tài Khoản / Email Hoặc Mật Khẩu Sai.";
			request.setAttribute("msg", msg);
			
			request.getRequestDispatcher("loginView").forward(request, response);
		}
	}

}
