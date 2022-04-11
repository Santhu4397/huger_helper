package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.UserDao;

import com.ty.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao dao;
	@RequestMapping("createuser")
	public ModelAndView creatUser() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("createUser.jsp");
		mv.addObject("users",new User());
		return mv;
	}
	@RequestMapping("saveuser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		dao.saveUser(user);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}
	@RequestMapping("/displayuser")
	public ModelAndView displayUser() {
		List<User> list=dao.getAllSUser();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("view-user.jsp");
		mv.addObject("users",list);
		return mv;
	}
	@RequestMapping("/edituser")
	public ModelAndView edit(@RequestParam int id) {
		User user=dao.getUserById(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("edit-user.jsp");
		
		mv.addObject("user",user);
		return mv;
	}
	@RequestMapping("/updateuser")
	public ModelAndView update(@ModelAttribute User user ) {
		ModelAndView mv=new ModelAndView();
		dao.updateUser(user);
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView delete(@RequestParam int id ) {
		ModelAndView mv=new ModelAndView();
		dao.deleteUser(id);
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}

}
