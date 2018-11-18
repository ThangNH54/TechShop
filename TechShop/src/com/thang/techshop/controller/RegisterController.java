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
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String code=request.getParameter("code");
		if(code.equals(session.getAttribute("code")))
		{
			//ghi vao database
			Customer customer=(Customer) session.getAttribute("waitConfirmRegister");
			session.removeAttribute("code");
			session.removeAttribute("waitConfirmRegister");
			session.removeAttribute("action");
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
			String msg="Mã Xác Thực Không Đúng.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("confirmEmailView").forward(request, response);
		}

	}


}
