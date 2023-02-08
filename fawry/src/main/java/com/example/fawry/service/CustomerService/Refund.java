package com.example.fawry.service.CustomerService;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.PaymentModel.CreditCard;
import com.example.fawry.model.TransactionModel.Transaction;


@Service
public class Refund {
public Transaction askForRefund(int transactionId,int id) {
		try {	
        		 if(DataBase.getdb1().validateTransaction(transactionId))
        		 {
        			 DataBase.refunds.put(transactionId,DataBase.getdb1().customerTransactions.get(transactionId));
        			 Transaction t=new Transaction("AskforRefund",DataBase.getdb1().customerTransactions.get(transactionId).getamount(),"refund",id);
        			 DataBase.customerTransactions.put(Transaction.getTransactionId(), t);
        			 return DataBase.getdb1().customerTransactions.get(transactionId);
        		 }		
    			return null;
    	}catch (Exception e) {
            System.out.println("Exception in pay as" + e.getMessage());
        }
		return null;
	}

public int CheckRefund(int transactionId) {
	
	try {	
		for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) {
    		 if(Objects.equals(entry.getKey(), transactionId)&& entry.getValue().isRefundStatus()=="Waiting")
    		 {	 
    			 return -1;
    		 }
    		 else if(Objects.equals(entry.getKey(), transactionId)&& entry.getValue().isRefundStatus()=="accepted"){
    			 return 1;
    		 }
    		 
    	}
			return 0;
	}catch (Exception e) {
        System.out.println("Exception in pay as" + e.getMessage());
    }
	return -2;
}
}

