package com.example.fawry.model.ServiceModel;


public class MonthlyReceipt extends LandlineServices {
	public MonthlyReceipt(String name){
		this.serviceName=name;
	}
	@Override
	public void setlandlinecost() {
		this.cost=cost*1;
		
	}

	@Override
	public void setCost(double cost) {
		this.cost=cost;
	}
	
}
