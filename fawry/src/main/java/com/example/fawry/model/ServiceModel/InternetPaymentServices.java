package com.example.fawry.model.ServiceModel;

public class InternetPaymentServices extends Services{
	public InternetPaymentServices(String serviceProvider,String serviceName){
		this.serviceProvider=serviceProvider;
		this.serviceName=serviceName;
	}
	public InternetPaymentServices() {}
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
