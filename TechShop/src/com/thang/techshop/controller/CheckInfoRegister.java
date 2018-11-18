package com.thang.techshop.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thang.techshop.dao.CustomerDao;
import com.thang.techshop.model.Customer;
import com.thang.techshop.service.CustomerService;
import com.thang.techshop.util.CreateHashCode;
import com.thang.techshop.util.SendMail;


public class CheckInfoRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public CheckInfoRegister() {
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {{
		
		try {
			String userName=request.getParameter("userName");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String confirmPassword=request.getParameter("confirmPassword");
			String firstName=request.getParameter("firstName"); 
			String lastName=request.getParameter("lastName"); 
			long phone=Integer.parseInt(request.getParameter("phoneNumber"));
			String addr=request.getParameter("addr"); 
			String sex=request.getParameter("sex"); 
			String urlAvatar="images/avatar/default.png";
			int ID=CustomerService.getCustomerID();

			Customer customer=new Customer(ID, userName, email, password, firstName, lastName, phone, addr, sex, urlAvatar);
			
			if(password.equals(confirmPassword))//kiem tra khop mat khau
			{
				if(CustomerDao.getCustomer(userName)==null&&CustomerDao.getCustomer(email)==null)//kiem tra tai khoan chua ton tai
				{
					//gui mail xac thuc
					String code=CreateHashCode.getCode();
					String content="Ma Xac Thuc Tai Khoan La : "+code+".";
					if(SendMail.send(request.getServletContext().getInitParameter("mailshop"), request.getServletContext().getInitParameter("passmailshop"), email, "Shop-Confirm Email", content)==true)
					{
						HttpSession session=request.getSession();
						session.setAttribute("code", code);
						session.setAttribute("email", email);
						session.setAttribute("waitConfirmRegister", customer);
						session.setAttribute("action", "signup");
						request.getRequestDispatcher("confirmEmailView").forward(request, response);
					}
					else
					{
						String msg="Message :Có Lỗi Xảy Ra Khi Xác Thực Email.Thử lại!";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("registerView").forward(request, response);
					}
	
				}
				else
				{
					String msg="Message :UserName hoặc Email đã được sử dụng!";
					request.setAttribute("msg", msg);
					
					request.getRequestDispatcher("registerView").forward(request, response);
				}
				
			}
			
			else
			{
				String msg="Message : Mật Khẩu Xác Thực Không Khớp!";
				request.setAttribute("msg", msg);
				
				request.getRequestDispatcher("registerView").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			String msg="Có Lỗi Xảy ra. Thử Lại";
			request.setAttribute("msg", msg);
			
			request.getRequestDispatcher("registerView").forward(request, response);
		}
	}
    }
}

