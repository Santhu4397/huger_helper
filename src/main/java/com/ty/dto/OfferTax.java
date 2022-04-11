package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OfferTax {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int offerId;
		private double cost;
		private double offer;
		private double GST;
		private double SGST;
		public int getOfferId() {
			return offerId;
		}
		public void setOfferId(int offerId) {
			this.offerId = offerId;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		public double getOffer() {
			return offer;
		}
		public void setOffer(double offer) {
			this.offer = offer;
		}
		public double getGST() {
			return GST;
		}
		public void setGST(double gST) {
			GST = gST;
		}
		public double getSGST() {
			return SGST;
		}
		public void setSGST(double sGST) {
			SGST = sGST;
		}
		

}
