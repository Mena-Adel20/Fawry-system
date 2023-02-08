package com.example.fawry.model.PaymentModel;

import com.example.fawry.model.TransactionModel.Transaction;

public class Wallet implements Payment {
	private  double balance;
	public double cost;
	public String serviceName;
	private String providerName;
	private int transactionId;
	

	@Override
	public void pay(double amount) {
		balance-=amount;
	}
	public  void addfunds(double d)
	{
		
		balance+=d;
	}

	public void setBalance(double balance) {
		this.balance=balance;
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
	public double getbalance() {
		return balance;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}
