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
import com.thang.techshop.service.CustomerService;
import com.thang.techshop.util.CreateHashCode;
import com.thang.techshop.util.SendMail;


/**
 * Servlet implementation class RegisterController
 */

public class ProcessRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String checkEmail=(String) session.getAttribute("checkEmail");

		// mail chua duoc xac nhan, kiem tra thong tin dang ky.
		//Neu Thong tin chinh xac,gui mail xac nhan dang ky tai khoan.
		if(checkEmail.equals("false")) 
		{
			try {
				
				String userName=request.getParameter("userName");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String firstName=request.getParameter("firstName"); 
				String lastName=request.getParameter("lastName"); 
				long phone=Integer.parseInt(request.getParameter("phoneNumber"));
				String addr=request.getParameter("addr"); 
				String sex=request.getParameter("sex"); 
				String urlAvatar="images/avatar/default.png";
				int ID=CustomerService.getCustomerID();
				
				Customer customer=new Customer(ID, userName, email, password, firstName, lastName, phone, addr, sex, urlAvatar);
				
				if(CustomerDao.getCustomer(userName)==null&&CustomerDao.getCustomer(email)==null)//kiem tra tai khoan chua ton tai
				{
					//gui mail xac thuc
					String code=CreateHashCode.getCode();
					String content="Ma Xac Thuc Tai Khoan La : "+code+".";
					if(SendMail.send(request.getServletContext().getInitParameter("mailshop"), request.getServletContext().getInitParameter("passmailshop"), email, "Shop-Confirm Email", content)==true)
					{
						session.setAttribute("code", code);
						session.setAttribute("email", email);
						session.setAttribute("waitConfirmRegister", customer);
						session.setAttribute("action", "signup");
						response.sendRedirect("confirmEmailView");
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
				
			} catch (Exception e) {
				
				String msg="Có Lỗi Xảy ra. Thử Lại";
				request.setAttribute("msg", msg);
				
				request.getRequestDispatcher("registerView").forward(request, response);
			}
		}
		
		else if(checkEmail.equals("true"))//da xac nhan email, ghi du lieu vao co so du lieu
		{
			//ghi vao database
			Customer customer=(Customer) session.getAttribute("waitConfirmRegister");
			session.removeAttribute("code");
			session.removeAttribute("waitConfirmRegister");
			session.removeAttribute("action");
			session.removeAttribute("checkEmail");
			if(CustomerService.register(customer))
			{
				String msg="Đăng ký tài khoản thành công! ";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
			else
				
			{
				String msg="Message :Có lỗi xảy ra . Không thể tạo tài khoản!";
				request.setAttribute("msg", msg);
				
				request.getRequestDispatcher("message.jsp").forward(request, response);
			}
		}
		
		else
		{
			String msg="Có Lỗi Xảy ra. Thử Lại";
			request.setAttribute("msg", msg);
			
			request.getRequestDispatcher("registerView").forward(request, response);
		}
		
		

	}


}
