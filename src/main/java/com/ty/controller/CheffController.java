package com.ty.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.ItemDao;
import com.ty.dao.OrderDao;
import com.ty.dao.ProductDao;
import com.ty.dao.UserDao;
import com.ty.dto.Item;
import com.ty.dto.Orders;
import com.ty.service.ProductService;
@Controller
public class CheffController {
	@Autowired
	ProductDao dao;
	@Autowired
	ItemDao itemDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	ProductService service;
	@Autowired
	UserDao userdao;

	

	@RequestMapping("viewallorderbycheff")
	public ModelAndView getAllOrders() {

		List<Orders> list =orderDao.getAllOrder();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view-allorders-cheff.jsp");
		modelAndView.addObject("orders", list);
		return modelAndView;

	}
	
	@RequestMapping("getitemsbycheff")
	public ModelAndView getAllOrders(HttpServletRequest req,@RequestParam int orderId) {

		List<Item> list =itemDao.getOrderItem(orderId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view-itemsbyordercheff.jsp");
		modelAndView.addObject("orders", list);
		return modelAndView;
	}
	@RequestMapping("updateorderbycheff")
	public ModelAndView updateOrder(HttpServletRequest req,@RequestParam int orderId) {
		
		Orders orders=orderDao.getOrderById(orderId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateorderbycheff.jsp");
		modelAndView.addObject("orders", orders);
		return modelAndView;
	}
	@RequestMapping("updateorderbyidcheff")
	public ModelAndView updateOrderbyid(HttpServletRequest req,@ModelAttribute Orders orders) {
				ModelAndView modelAndView = new ModelAndView();
				orderDao.updateOrder(orders);
		modelAndView.setViewName("cheff-home.jsp");
		modelAndView.addObject("orders",orders);
		return modelAndView;
	
	}
}
