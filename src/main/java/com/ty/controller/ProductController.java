package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.ProductDao;
import com.ty.dto.Product;


@Controller
public class ProductController {

	@Autowired
	ProductDao dao;

	@RequestMapping("createproduct")
	public ModelAndView createProduct() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("create-product.jsp");
		modelAndView.addObject("product", new Product());
		return modelAndView;
	}

	@RequestMapping("saveproduct")
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		dao.saveProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin-home.jsp");
		return modelAndView;
	}

	@RequestMapping("viewproduct")
	public ModelAndView getAllProducts() {

		List<Product> list = dao.getAllProducts();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view-product.jsp");
		modelAndView.addObject("product", list);
		return modelAndView;

	}

	@RequestMapping("editproduct")
	public ModelAndView editProduct(@RequestParam int id) {
		Product product = dao.getProductById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("edit-product.jsp");
		return modelAndView;
	}

	@RequestMapping("updateproduct")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		dao.updateProduct(product);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin-home.jsp");
		return modelAndView;
	}

	@RequestMapping("deleteproduct")
	public ModelAndView deleteStudent(@RequestParam int id) {
		Product product=dao.getProductById(id);
		dao.deleteProduct(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin-home.jsp");
		return modelAndView;
	}


	@RequestMapping("viewitem")
	public ModelAndView getAllItems() {

		List<Product> list = dao.getAllProducts();
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("view-item.jsp");
		modelAndView.addObject("product",list);
		return modelAndView;

	}
}
