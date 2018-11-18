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
 * Servlet implementation class ForgotPassController
 */
@WebServlet("/ForgotPassController")
public class ForgotPassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if((boolean)(session.getAttribute("waitVeritifiCode"))==true)//xac thuc email
		{
			String code=request.getParameter("code");
			if(code.equals(session.getAttribute("code")))//da xac thuc
			{
				session.setAttribute("waitVeritifiCode",false);
				session.removeAttribute("action");
				session.removeAttribute("email");
				request.getRequestDispatcher("addNewPass").forward(request, response);
			}
			else
			{
				String msg="Mã Xác Thực Không Đúng.";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("confirmEmailView").forward(request, response);
			}

		}
		else
		{
			String password=request.getParameter("password");
			String confirmPassword=request.getParameter("confirmPassword");
			if(password.equals(confirmPassword))
			{
				Customer customer=(Customer) session.getAttribute("accountForgotPass");
				customer.setPassword(password);
				if(CustomerDao.updateCustomer(customer, 4))
				{
					session.removeAttribute("waitVeritifiCode");
					session.removeAttribute("accountForgotPass");
					request.setAttribute("msg", "Đổi Mật Khẩu Thành Công.");
					request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Mật Khẩu Xác Thực Không Khớp.");
				request.getRequestDispatcher("addNewPass").forward(request, response);
						
			}
		}
	}

}
