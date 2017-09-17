package com.digimation.gujjubus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.PassDetailBean;
import com.digimation.gujjubus.dao.PassDetailDAO;
public class UserPassRenewConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PassDetailBean passDetailBean=(PassDetailBean)session.getAttribute("passDetailBean");
			new PassDetailDAO().renewPass(passDetailBean);
			response.sendRedirect("UserPassPrint.jsp");
	}

}
