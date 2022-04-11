package com.ty.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@Controller
public class LoginController {
	@Autowired
	UserDao dao ;
	@PostMapping("login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		
		User user = dao.validateUser(request.getParameter("mail"), request.getParameter("password"));
		System.out.println(request.getParameter("mail") + " " + request.getParameter("password"));
		if (user != null) {
			HttpSession session = request.getSession();

			session.setAttribute("staffId", user.getId());
			session.setAttribute("userrole", user.getRole());
			if (user.getRole().equalsIgnoreCase("staff")) {
				session.setAttribute("staffname", user.getName());
				view.setViewName("staff-home.jsp");
				return view;
			} else if (user.getRole().equalsIgnoreCase("admin")){
				session.setAttribute("adminname", user.getName());
				view.setViewName("admin-home.jsp");
				return view;
			}
			else {
				session.setAttribute("cheffname", user.getName());
				view.setViewName("cheff-home.jsp");
				return view;
			}
		}
		view.setViewName("Login.jsp");
		return view;
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		view.setViewName("Login.jsp");
		return view;
	}

}
