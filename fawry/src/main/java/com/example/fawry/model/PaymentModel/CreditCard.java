package com.example.fawry.model.PaymentModel;

import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.model.TransactionModel.Transaction;

public class CreditCard implements Payment {
	private String cardnumber;
	private String password;
	private  double cardBalance;
	public double cost;
	public String serviceName;
	private String providerName;
	private static double funds=0.0;
	private static double walletbalance;	
	private int transactionId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public void pay(double amount) {
		cardBalance-=amount;
	}
    public void AddFundsToWallet(double amount,Account a) {
    	
    	a.wallet.addfunds(amount);
    	a.credit.setCardBalance(a.credit.getCardBalance()-amount);
    	walletbalance=a.wallet.getbalance();
    }
    public double getwalletbalance()
	{
		return walletbalance;
	}
    
	public void setcardinfo(String num,String pass)
	{
		this.cardnumber=num;
		this.password=pass;
	}
	public String getcardnum()
	{
		return cardnumber;
	}
	public String getpass()
	{
		return password;
	}
	
	public  void addfunds() {
		cardBalance+=funds;
	}
	public double getCardBalance() {
		return cardBalance;
	}
	
	public void setCardBalance(double cardBalance) {
		this.cardBalance=cardBalance;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public static double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
	
	
}
