package com.digimation.gujjubus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.ReservationBean;
import com.digimation.gujjubus.bean.UserBean;
import com.digimation.gujjubus.dao.ReservationDAO;

public class ShowReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			UserBean userBean= (UserBean)session.getAttribute("userBean");
			ArrayList<ReservationBean> reservationBeans= new ReservationDAO().getUserReservationList(userBean.getUserId());
			session.setAttribute("reservationBean",reservationBeans);
			request.getRequestDispatcher("ShowUserReservation.jsp").forward(request, response);
	}	

}
