package com.example.fawry.model.ServiceModel;



public abstract class Services {
	protected double cost;
	public String serviceName;
	public abstract double cost();
	public abstract void setCost(double cost);
	public abstract String getserviceName();
	protected String serviceProvider;
	public String getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	

}
