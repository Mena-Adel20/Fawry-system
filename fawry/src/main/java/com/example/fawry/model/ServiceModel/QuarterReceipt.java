package com.example.fawry.model.ServiceModel;


public class QuarterReceipt extends LandlineServices {
	public QuarterReceipt(String name){
		this.serviceName=name;
	}
	@Override
	public void setlandlinecost() {
		this.cost=cost*3;
		
	}
	@Override
	public void setCost(double cost) {
		this.cost=cost*3;
	}
}
