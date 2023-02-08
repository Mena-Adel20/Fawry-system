package com.example.fawry.model.ServiceModel;

public class mobileRechargeService extends Services {
	public mobileRechargeService(String serviceProvider,String serviceName){
		this.serviceProvider=serviceProvider;
		this.serviceName=serviceName;
	}
	public mobileRechargeService () {}
	
	@Override
	public double cost() {
		
		return this.cost;
	}

	@Override
	public void setCost(double cost) {
		this.cost=cost;
		
	}
	public void setsername(String description) {
	 this.serviceName=description;
	}
	@Override
	public String getserviceName() {
		return this.serviceName;
	}
}
