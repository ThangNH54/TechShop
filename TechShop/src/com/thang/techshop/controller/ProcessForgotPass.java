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
 * Servlet implementation class ProcessForgotPass
 */
@WebServlet("/ProcessForgotPass")
public class ProcessForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessForgotPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		String message=(String) session.getAttribute("forgotPass");
		
		if(message.equals("CHECKUSER"))//kiem tra tai khoan ton tai hay khong
		{
			String userName=request.getParameter("userName");
			Customer customer=CustomerDao.getCustomer(userName);
			if(customer!=null)
			{
				//gui mail xac thuc
				String code=CreateHashCode.getCode();
				String content="Ma Xac Thuc Tai Khoan La : "+code+".";
				if(SendMail.send(request.getServletContext().getInitParameter("mailshop"), request.getServletContext().getInitParameter("passmailshop"), customer.getEmail(), "Shop-Confirm Email", content)==true)
				{
					session.setAttribute("code", code);
					session.setAttribute("accountForgotPass", customer);
					session.setAttribute("email", customer.getEmail());
					session.setAttribute("action", "forgotPass");
					session.setAttribute("forgotPass","CHECKEMAIL");
					session.setAttribute("checkEmail","false");
					response.sendRedirect("confirmEmailView");
				}
				
			}
			else 
			{
				request.setAttribute("msg", "Tài Khoản Không Tồn Tại.");
				request.getRequestDispatcher("forgotPassView").forward(request, response);
			}
		
		}
		
		else if(((String)session.getAttribute("checkEmail")).equals("true"))
		{
			session.removeAttribute("action");
			session.removeAttribute("email");
			session.setAttribute("forgotPass","ADDNEWPASS");
			session.setAttribute("checkEmail","false");
			request.getRequestDispatcher("addNewPass").forward(request, response);
		}

		
		else if(message.equals("ADDNEWPASS"))
		{
			String password=request.getParameter("password");

			Customer customer=(Customer) session.getAttribute("accountForgotPass");
			customer.setPassword(password);
			if(CustomerDao.updateCustomer(customer, 4))
			{
				session.removeAttribute("waitVeritifiCode");
				session.removeAttribute("accountForgotPass");
				session.removeAttribute("forgotPass");
				request.setAttribute("msg", "Đổi Mật Khẩu Thành Công.");
				session.removeAttribute("checkEmail");
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
			}
			else
			{
				request.setAttribute("msg", "Xảy Ra Lỗi.");
				request.getRequestDispatcher("forgotPassView").forward(request, response);
						
			}
		}
	}

