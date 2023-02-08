package com.example.fawry.service.CustomerService;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;




import com.example.fawry.model.DiscountModel.DiscountDecorator;
import com.example.fawry.model.PaymentModel.Cashe;
import com.example.fawry.model.PaymentModel.CreditCard;
import com.example.fawry.model.PaymentModel.Wallet;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.model.ServiceModel.Services;
import com.example.fawry.model.TransactionModel.Transaction;

@Service
public class FinancialService {
	public boolean PayWithWallet(Wallet payment ,int id,Account a) {
    	try {	
        		 if( DataBase.getdb1().validatepayment( payment)!=null) 
        		 {
        			 double dis=0;
        			 for (DiscountDecorator discount : DataBase.getdb1().discounts )  {
        				 if(payment.getServiceName().equals(discount.getsername()))
        					 dis+=discount.getdiscount(); 
        			 }
        			 if(dis!=0) {
        				 
        		
        				 a.wallet.setCost(payment.getCost()-(payment.getCost()*dis));
  
        				 a.wallet.pay(a.wallet.getCost());
        		    DataBase.getdb1().validatepayment( payment).setCost(payment.getCost());
        			 Transaction t=new Transaction(payment.getServiceName(),a.wallet.getCost(),"payment",id);
        			 payment.setTransactionId(Transaction.getTransactionId());
        			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
        			 }
        			 else
        			 {
        				 a.wallet.pay(payment.getCost());
        				  DataBase.getdb1(). validatepayment( payment).setCost(payment.getCost());
             			 Transaction t=new Transaction(payment.getServiceName(),a.wallet.getCost(),"payment",id);
             			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
             			payment.setTransactionId(Transaction.getTransactionId());

        			 
        			 }
        			 return true;
        		 }
    			return false;
    	}catch (Exception e) {
            System.out.println("Exception in pay as" + e.getMessage());
        }
    	return true;
    }
	public boolean PayWithCreditCard(CreditCard payment,int id,Account a) {
		try {	
    		for (Services entry :  DataBase.getdb1().providersServices){
        		 if(entry.getserviceName().toLowerCase().equals(payment.getServiceName().toLowerCase())&&
        				 entry.getServiceProvider().toLowerCase().equals(payment.getProviderName().toLowerCase())) 
        		 {
        			 double dis=0;
        			 for (DiscountDecorator discount : DataBase.getdb1().discounts )  {
        				 if(payment.getServiceName().equals(discount.getsername()))
        					 dis+=discount.getdiscount(); 
        			 }
        			 if(dis!=0) {
        				 
        			a.credit.setCost(payment.getCost()-(payment.getCost()*dis));
        			a.credit.pay(a.credit.getCost());
        			 entry.setCost(payment.getCost());
        			 Transaction t=new Transaction(payment.getServiceName(),a.credit.getCost(),"payment",id);
        			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
        			 payment.setTransactionId(Transaction.getTransactionId());

        			 }
        			 else
        			 {
        				 entry.setCost(payment.getCost());
        				 a.credit.pay(payment.getCost());
             			 Transaction t=new Transaction(payment.getServiceName(),a.credit.getCost(),"payment",id);
             			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
             			payment.setTransactionId(Transaction.getTransactionId());

        			 }
        			 return true;

        		 }
        			
        		        	
        	}
    		
    			return false;
    	}catch (Exception e) {
            System.out.println("Exception in pay as" + e.getMessage());
        }
    	

    	return true;
    }
	public boolean PayWithCashe(Cashe payment,int id) {
		try {	
    		for (Services entry :  DataBase.getdb1().providersServices){
        		 if(entry.getserviceName().toLowerCase().equals(payment.getServiceName().toLowerCase())&&
        				 entry.getServiceProvider().toLowerCase().equals(payment.getProviderName().toLowerCase())) 
        		 {
        			 double dis=0;
        			 for (DiscountDecorator discount : DataBase.getdb1().discounts )  {
        				 if(payment.getServiceName().equals(discount.getsername()))
        					 dis+=discount.getdiscount(); 
        			 }
        			 if(dis!=0) {
        				 
        				 payment.setCost(payment.getCost()-(payment.getCost()*dis));
        		    payment.pay(payment.getCost());
        			 entry.setCost(payment.getCost());
        			 Transaction t=new Transaction(payment.getServiceName(),payment.getCost(),"payment",id);
        			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
        			 payment.setTransactionId(Transaction.getTransactionId());

        			 }
        			 else
        			 {
        				 payment.pay(payment.getCost());
            			 entry.setCost(payment.getCost());
            			 Transaction t=new Transaction(payment.getServiceName(),payment.getCost(),"payment",id);
            			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
            			 payment.setTransactionId(Transaction.getTransactionId());

        			 }
        			 return true;
        		 }
        			
        		        	
        	}
    		
    			return false;
    	}catch (Exception e) {
            System.out.println("Exception in pay as" + e.getMessage());
        }
    	

    	return true;
    }
	public boolean AddFundsToWallet(CreditCard card,int id,Account a) {
    	try {	
        		     card.AddFundsToWallet(CreditCard.getFunds(),a);
        		     Transaction t=new Transaction("AddToWallet",CreditCard.getFunds(),"wallet",id);
        			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
        			 card.setTransactionId(Transaction.getTransactionId());

        			 return true;
    	}
    	catch (Exception e) {
            System.out.println("Exception in pay as" + e.getMessage());
            return false;
        }
    }
	
}
	
	
