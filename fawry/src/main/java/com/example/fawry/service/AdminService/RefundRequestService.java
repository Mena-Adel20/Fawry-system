package com.example.fawry.service.AdminService;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;


import com.example.fawry.model.PaymentModel.Wallet;
import com.example.fawry.model.TransactionModel.Transaction;


@Service
public class RefundRequestService {
	public boolean acceptRefund(int id) {
		try {
   		 if(DataBase.getdb1().validateRefund( id))
   		 {
   			DataBase.getdb1().refunds.get(id).setRefundStatus("accepted");
   			int custid =DataBase.getdb1().refunds.get(id).getcustid();
   			custid--;
   			DataBase.getdb1().cust_accounts.get(custid).wallet.addfunds(DataBase.getdb1().refunds.get(id).getamount());
   			 DataBase.getdb1().refunds.remove(id);
   			 return true;
   		 }   			   		        	
   			return false;
	}catch (Exception e) {
       System.out.println("Exception in pay as" + e.getMessage());
   }
	return true;
	}
	public boolean rejectRefund(int id) {
		try {
		
   		 if(DataBase.getdb1().validateRefund( id))
   		 {
   			DataBase.getdb1().refunds.get(id).setRefundStatus("rejected");
   			DataBase.getdb1().refunds.remove(id);
   			 return true;
   		 }
   			   		        	
   				return false;
	}catch (Exception e) {
       System.out.println("Exception in pay as" + e.getMessage());
   }
	return true;
	}
}
