package com.ty.food.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String gstName;
	private double gstValue ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGstName() {
		return gstName;
	}
	public void setGstName(String gstName) {
		this.gstName = gstName;
	}
	public double getGstValue() {
		return gstValue;
	}
	@Override
	public String toString() {
		return "Tax [" + gstName + " = " + gstValue + "]";
	}
	public void setGstValue(double gst) {
		this.gstValue = gst;
	}
	
	
}
