package com.ty.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.ItemDao;
import com.ty.dao.OrderDao;
import com.ty.dao.ProductDao;
import com.ty.dao.UserDao;
import com.ty.dto.Item;
import com.ty.dto.Orders;
import com.ty.dto.Product;
import com.ty.dto.User;
import com.ty.service.ProductService;

@Controller
public class CartController {
	double totalCost;
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

	@RequestMapping("additem")
	public ModelAndView createCart(int id, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Product product = dao.getProductById(id);
		if (product.getId() == id) {
			mv.setViewName("editkartitem");
		}
		Item item = new Item();
		item.setCost(product.getCost());
		item.setName(product.getName());
		mv.setViewName("edit-view-kart.jsp");
		mv.addObject("items", item);
		return mv;
	}

	@RequestMapping("editkartitem")
	public ModelAndView creatCart(HttpServletRequest req, @ModelAttribute Item items) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		Object object = session.getAttribute("items");
		if (object == null) {
			List<Item> list = new ArrayList<Item>();
			list.add(items);
			session.setAttribute("items", list);
			mv.setViewName("viewkart.jsp");
			mv.addObject("items", new Item());
			return mv;

		} else {
			List<Item> list = (List<Item>) session.getAttribute("items");
			list.add(items);
			session.setAttribute("items", list);
			mv.addObject("items", new Item());
			mv.setViewName("viewkart.jsp");
			return mv;
		}
	}
//	@RequestMapping("edititem")
//	public ModelAndView editcart( HttpServletRequest req,@ModelAttribute Item item) {
//       System.out.println(item.getQuantity());
//       HttpSession session = req.getSession();
//		List<Item> list = (List<Item>) session.getAttribute("items");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("viewkart.jsp");
//		mv.addObject("items",list);
//		return mv;
//	}
//	
//	@RequestMapping("edititem")
//	public ModelAndView edititem( HttpServletRequest req,@ModelAttribute Item items) {
//System.out.println(items.getQuantity());
//
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("edit-view-kart.jsp");
//		mv.addObject("items",items);
//		return mv;
//	}

	@RequestMapping("placeorder")
	public ModelAndView placeorder(HttpServletRequest req) {
		HttpSession session = req.getSession();

		List<Item> items = (List<Item>) session.getAttribute("items");
		for (Item t : items) {
		}
		session.setAttribute("items", items);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("order", new Orders());
		modelAndView.setViewName("create-order.jsp");
		return modelAndView;
	}

	@RequestMapping("createorder")
	public ModelAndView saveOrder(@ModelAttribute Orders order, HttpServletRequest req) {
		double price = service.findTotalCost(req);
		HttpSession session = req.getSession();
		List<Item> list = (List<Item>) session.getAttribute("items");
		int id = (int) session.getAttribute("staffId");
		User user = userdao.getUserById(id);

		order.setTotalCost(price);
		order.setDateTime(LocalDateTime.now());
		List<Item> item = new ArrayList<Item>();
		for (Item product : list) {
			Item itemdto = new Item();
			itemdto.setName(product.getName());
			itemdto.setCost(product.getCost());
			itemdto.setQuantity(product.getQuantity());
			itemdto.setOrder(order);

			item.add(itemdto);

			itemDao.saveItem(itemdto);
		}

		order.setUser(user);
		order.setItems(item);
		orderDao.saveOrder(order);

		session.setAttribute("items", null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orders", order);
		modelAndView.setViewName("View-Order.jsp");
		return modelAndView;
	}

	@RequestMapping("viewallorder")
	public ModelAndView getAllOrders() {

		List<Orders> list = orderDao.getAllOrder();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view-allorders.jsp");
		modelAndView.addObject("orders", list);
		return modelAndView;

	}

	@RequestMapping("getitems")
	public ModelAndView getAllOrders(HttpServletRequest req) {
		String id = req.getParameter("orderId");

		List<Item> list = itemDao.getOrderItem(Integer.parseInt(id));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view-itemsbyorder.jsp");
		modelAndView.addObject("orders", list);
		return modelAndView;
	}

	@RequestMapping("updateorder")
	public ModelAndView updateOrder(HttpServletRequest req) {
		String id = req.getParameter("orderId");
		Orders orders = orderDao.getOrderById(Integer.parseInt(id));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update-order.jsp");
		modelAndView.addObject("orders", orders);
		return modelAndView;
	}

	@RequestMapping("updateorderbyid")
	public ModelAndView updateOrderbyid(HttpServletRequest req, @ModelAttribute Orders orders) {
		ModelAndView modelAndView = new ModelAndView();
		orderDao.updateOrder(orders);
		modelAndView.setViewName("View-Order.jsp");
		modelAndView.addObject("orders", orders);
		return modelAndView;
	}
@RequestMapping("deleteorder")
	public ModelAndView deleteorder(@RequestParam int orderId ) {
		ModelAndView modelAndView = new ModelAndView();
		boolean t=itemDao.deleteItem(orderId);
		System.out.println(t);
		modelAndView.setViewName("staff-home.jsp");
		
		return modelAndView;
	}
}
