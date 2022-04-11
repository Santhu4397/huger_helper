package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.OfferTaxDao;
import com.ty.dao.UserDao;
import com.ty.dto.OfferTax;
import com.ty.dto.User;
@Controller
public class OfferController {
	@Autowired
	OfferTaxDao dao;
	@RequestMapping("createoffer")
	public ModelAndView creatUser() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("create-offer.jsp");
		mv.addObject("offer",new OfferTax());
		return mv;
	}
	@RequestMapping("saveoffer")
	public ModelAndView saveUser(@ModelAttribute OfferTax offer) {
		dao.saveOffer(offer);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}
	@RequestMapping("/displayoffer")
	public ModelAndView displayUser() {
		List<OfferTax> list=dao.getAllTax();
		System.out.println(list.get(1).getCost());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("view-offer.jsp");
		mv.addObject("Offers",list);
		return mv;
	}
	@RequestMapping("/editoffer")
	public ModelAndView edit(@RequestParam int id) {
		OfferTax offer=dao.getOfferById(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("edit-user.jsp");
		
		mv.addObject("offer",offer);
		return mv;
	}
	@RequestMapping("/updateoffer")
	public ModelAndView update(@ModelAttribute OfferTax offer ) {
		ModelAndView mv=new ModelAndView();
		dao.updateoffer(offer);
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}
	
	@RequestMapping("/deleteoffer")
	public ModelAndView delete(@RequestParam int id ) {
		ModelAndView mv=new ModelAndView();
		dao.deleteoffer(id);
		mv.setViewName("admin-home.jsp");
		
		return mv;
	}


}
