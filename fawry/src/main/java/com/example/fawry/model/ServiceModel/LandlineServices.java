package com.example.fawry.model.ServiceModel;


public abstract class  LandlineServices extends Services {
	
	public LandlineServices () {
		
	}
	
	public double cost() {
		
		return this.cost;
	}
	public abstract void setlandlinecost();
    
	public String getserviceName() {
		return this.serviceName;
	}

}
