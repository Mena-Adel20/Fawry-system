package com.example.fawry.database;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;

import org.springframework.stereotype.Component;

import com.example.fawry.model.*;
import com.example.fawry.model.DiscountModel.DiscountDecorator;
import com.example.fawry.model.PaymentModel.Wallet;
import com.example.fawry.model.ProvidersModel.Provider;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.model.ServiceModel.Donations;
import com.example.fawry.model.ServiceModel.InternetPaymentServices;
import com.example.fawry.model.ServiceModel.MonthlyReceipt;
import com.example.fawry.model.ServiceModel.QuarterReceipt;
import com.example.fawry.model.ServiceModel.Services;
import com.example.fawry.model.ServiceModel.mobileRechargeService;
import com.example.fawry.model.TransactionModel.Transaction;
/**
*
* @author 
*/
@Component

public class DataBase {
	private String adminUserName="admin";
    private String adminPasswod="12345";
    private static DataBase database=null;
    public static Map<String, Provider> providers = new HashMap<String, Provider>();
    public static Vector<DiscountDecorator> discounts=new Vector<>();
    public static Map<Integer, Account> cust_accounts = new HashMap<Integer , Account>();
    public static Map<Integer,Transaction>refunds=new HashMap<Integer,Transaction>();
    public static Map<Integer,Transaction>customerTransactions=new HashMap<Integer,Transaction>();
    public  Vector<Services> providersServices=new Vector<>();
    public boolean ValidateSignUp(Account a)
	{
		if(DataBase.getdb1().cust_accounts.isEmpty()) {
			return true;
    	}
    	for (Map.Entry<Integer, Account> entry : DataBase.getdb1().cust_accounts.entrySet()) {
    		 if(Objects.equals(entry.getValue().getUser_name(),a.getUser_name()) || Objects.equals(entry.getValue().getEmail(), a.getEmail()) )
    			return false;
    		        	
    	}
    	return true;
		
	}
    public Account ValidateSignIn(String em,String pass)
    {
    	for (Map.Entry<Integer, Account> entry : DataBase.getdb1().cust_accounts.entrySet()) {
    		if(DataBase.getdb1().cust_accounts.isEmpty())
    			return null;
    		else if(Objects.equals(entry.getValue().getPassword(), pass) && Objects.equals(entry.getValue().getEmail(), em) )
    			return entry.getValue();;
    		
    }
    	return null;
    }
    public boolean validatediscount(DiscountDecorator d) 
	{
		if(DataBase.getdb1().discounts.isEmpty()) {
			return true;
    	}
    	for (DiscountDecorator entry : DataBase.getdb1().discounts ) {
    		 if(entry.getsername().toLowerCase().equals(d.getsername().toLowerCase()) && entry.getDiscountname().toLowerCase().equals(d.getDiscountname().toLowerCase())) 
    		 {  
    			 return false;
    		 }
    	}
    	return true;
		
	}
    public boolean validateService(String description)
	 {
		 for (Services entry :  DataBase.getdb1().providersServices) {

       		if(entry.getserviceName().toLowerCase().equals( description.toLowerCase()) )
       			return true;
       	}
		 return false;
	 }
    public boolean validateTransaction(int id)
    {
    	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) {
    		 if(Objects.equals(entry.getKey(), id))
    		 {
    			 
    			 return true;
    		 }
    	}
    		 return false;
    }
    public boolean validateRefund(int id)
    {
    	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().refunds.entrySet()) {
    		 if(Objects.equals(entry.getKey(), id))
    		 {
    			 
    			 return true;
    		 }
    	}
    		 return false;
    }
	public boolean validateProvider(String s)
	{
		if(DataBase.getdb1().providers.get(s.toLowerCase())==null) {
			return true;
		}
		return false;
	}
	public Services validatepayment(Wallet payment)
	{
		for (Services entry :  DataBase.getdb1().providersServices){
   		 if(entry.getserviceName().toLowerCase().equals(payment.getServiceName().toLowerCase())&&
   				 entry.getServiceProvider().toLowerCase().equals(payment.getProviderName().toLowerCase())) 
   		 {
   			 return entry;
   		 }
		}
		return null;
		
	}
public int getcustid(Account a)
{
	
	for (Map.Entry<Integer, Account> entry : DataBase.getdb1().cust_accounts.entrySet()) {
		 if(Objects.equals(entry.getValue().getUser_name(),a.getUser_name()) || Objects.equals(entry.getValue().getEmail(), a.getEmail()) )
			return entry.getKey();
		        	
	}
	return -1;
}
    public void setAdminUserName(String name) {
		this.adminUserName=name;
	}
    public void setAdminPassword(String pass) {
		this.adminPasswod=pass;
	}
    public String getAdminName() {
    	return this.adminUserName;
    }
    
    public String getAdminPassword() {
    	return this.adminPasswod;
    }
    public static DataBase getdb1()
    {
    	if(database==null)
    		database=new DataBase();
    	return database;
    }
    private DataBase()
    {
    	   
    	   Services service3=new QuarterReceipt("QuarterReceipt");
    	   Services service4=new MonthlyReceipt("MonthlyReceipt");
    	   Services service5=new Donations("Donations");
    	   Services vodafoneinternetService=new InternetPaymentServices("vodafone","InternetPayment");
    	   Services weinternetservice=new InternetPaymentServices("we","InternetPayment");
    	   Services etisalatinternetervice=new InternetPaymentServices("etisalat","InternetPayment");
    	   Services orangeinternetservice=new InternetPaymentServices("orange","InternetPayment");
    	   Services vodafoneRechargeservice=new  mobileRechargeService("vodafone","mobileRecharge");
    	   Services weRechargeservice2=new  mobileRechargeService("we","mobileRecharge");
    	   Services etisalatRechargeservice2=new  mobileRechargeService("etisalat","mobileRecharge");
    	   Services orangeRechargeservice2=new  mobileRechargeService("orange","mobileRecharge");
    	
    	   providersServices.add(vodafoneinternetService);
    	   providersServices.add(weinternetservice);
    	   providersServices.add(etisalatinternetervice);
    	   providersServices.add(orangeinternetservice);
    	   providersServices.add(vodafoneRechargeservice);
    	   providersServices.add(weRechargeservice2);
    	   providersServices.add(etisalatRechargeservice2);
    	   providersServices.add(orangeRechargeservice2);
    	   providersServices.add(service3);
    	   providersServices.add(service4);
    	   providersServices.add(service5);
    }
}
