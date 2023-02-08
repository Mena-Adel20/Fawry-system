package com.example.fawry.model.ServiceModel;


public class Donations extends Services {
	public Donations (String name) {
		this.serviceName=name;
	}
	
	public double cost() {
		
		return this.cost;
	}

	@Override
	public void setCost(double cost) {
		super.cost=cost;
		
	}
    
	public String getserviceName() {
		return this.serviceName;
	}

}
