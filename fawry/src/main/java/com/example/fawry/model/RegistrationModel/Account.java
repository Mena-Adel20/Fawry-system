package com.example.fawry.model.RegistrationModel;

import com.example.fawry.model.PaymentModel.CreditCard;
import com.example.fawry.model.PaymentModel.Wallet;
import com.example.fawry.model.TransactionModel.Transaction;

public class Account {
	private String user_name;
    private String password;
    private String email;
    public static int custid=0;
    public Wallet wallet=new Wallet();
    private double walletbalance;
    public CreditCard credit=new CreditCard();
    private double cardbalance;

    
     public Account()
     {
    	   
     }

    public void setEmail(String email) {
        this.email = email;

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }
    public static int getcustId() {
		return Account.custid;
	}

    public String toString() {
		return user_name + "::" + email + "::" + password;
	}

	public double getWalletbalance() {
		return walletbalance;
	}

	public void setWalletbalance(double walletbalance) {
		this.walletbalance = walletbalance;
	}

	public double getCardbalance() {
		return cardbalance;
	}

	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}
}
