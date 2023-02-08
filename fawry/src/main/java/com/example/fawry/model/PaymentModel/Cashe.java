package com.example.fawry.model.PaymentModel;


public class Cashe implements Payment {
	private static double cashValue=100000.0;
	public double cost;
	public String serviceName;
	private String providerName;
	private int transactionId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public void pay(double amount) {
		cashValue-=amount;
	}
	public static double getCashValue() {
		return cashValue;
	}
	public void setCashValue(double cash) {
		this.cashValue=cash;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getProviderName() {
		return providerName;
	}


	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
}
