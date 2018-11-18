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
 * Servlet implementation class EditInfoCustomerController
 */
@WebServlet("/EditInfoCustomerController")
public class EditInfoCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
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
			

			Customer customer=new Customer(-1, userName, email, password, firstName, lastName, phone, addr, sex,"");
			
			if(password.equals(confirmPassword))//kiem tra khop mat khau
			{
				
				Customer customerTmp=(Customer) session.getAttribute("account");
				customer.setiD(customerTmp.getiD());
				customer.setUrlAvatar(customerTmp.getUrlAvatar());
				boolean checkUpdate=true;
				
				if(!customer.getPassword().equals(customerTmp.getPassword()))
				{
					if(!CustomerDao.updateCustomer(customer, 4)) checkUpdate=false;
				}
				if(!customer.getFirstName().equals(customerTmp.getFirstName()))
				{
					if(!CustomerDao.updateCustomer(customer, 5)) checkUpdate=false;
				}
				if(!customer.getLastName().equals(customerTmp.getLastName()))
				{
					if(!CustomerDao.updateCustomer(customer, 6)) checkUpdate=false;
				}
				if(!(customer.getPhone()==customerTmp.getPhone()))
				{
					if(!CustomerDao.updateCustomer(customer, 7)) checkUpdate=false;
				}
				if(!customer.getAddr().equals(customerTmp.getAddr()))
				{
					if(!CustomerDao.updateCustomer(customer, 8)) checkUpdate=false;
				}
				if(!customer.getSex().equals(customerTmp.getSex()))
				{
					if(!CustomerDao.updateCustomer(customer, 9)) checkUpdate=false;
				}
				
				if(checkUpdate==true)
				{
					String msg="Cập Nhật Thông Tin Thành Công.";
					request.setAttribute("msg", msg);
					session.setAttribute("account", customer);
					request.getRequestDispatcher("message.jsp").forward(request, response);
				}
				else
				{
					String msg="Cập Nhật Thông Tin Thất Bại.";
					request.setAttribute("msg", msg);
					
					request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}
			
			else
			{
				String msg="Message : Mật Khẩu Xác Thực Không Khớp!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editInfoCustomerView").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			String msg="Có Lỗi Xảy ra. Thử Lại";
			request.setAttribute("msg", msg);
			
			request.getRequestDispatcher("editInfoCustomerView").forward(request, response);
		}
	}



}
