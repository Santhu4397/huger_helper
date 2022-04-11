package com.ty.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.dao.OfferTaxDao;
import com.ty.dto.Item;
import com.ty.dto.OfferTax;
import com.ty.dto.Product;

@Service
public class ProductService {
	@Autowired
	OfferTaxDao dao;
	double totalPrice;
	double discount;
	double price;
	

	public double findTotalCost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<Item> items = (List<Item>) session.getAttribute("items");
		for (Item list : items) {
			price=list.getCost()*list.getQuantity();
			list.setCost(price);
			totalPrice=totalPrice+price;
		}
		List<OfferTax> list = dao.getAllTax();
		for (OfferTax tax : list) {
			OfferTax offer = dao.getOfferById(tax.getOfferId());
			if (totalPrice > offer.getCost()) {
				totalPrice = (totalPrice - tax.getOffer());
				totalPrice = (totalPrice * tax.getGST());
				totalPrice = (totalPrice * tax.getSGST());
				return totalPrice;
			}
		}
		return totalPrice;
	}
}
