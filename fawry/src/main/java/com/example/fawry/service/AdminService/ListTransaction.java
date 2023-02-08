package com.example.fawry.service.AdminService;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Service;
import com.example.fawry.database.DataBase;
import com.example.fawry.model.TransactionModel.Transaction;
@Service

public class ListTransaction {
	public ArrayList<Transaction> listTransactions(String type) {
        try {
        	ArrayList<Transaction>d=new ArrayList <Transaction>();
        if(type.toLowerCase().equals("payment"))	{
        	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) {
          		 if(Objects.equals(entry.getValue().getType(), "payment"))
          		 {
          			 d.add(entry.getValue());
          		 }
        	         } 
        	return d;
        	 }
        else if(type.toLowerCase().equals("refund")) {
        	
        	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) {
         		 if(Objects.equals(entry.getValue().getType(), "refund"))
         		 {
         			 d.add(entry.getValue());
         		 }
       	         } 
       	return d;
        }
        else if (type.toLowerCase().equals("wallet")) {
        	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) {
        		 if(Objects.equals(entry.getValue().getType(), "wallet"))
        		 {
        			 d.add(entry.getValue());
        		 }
      	         } 
      	return d;
        	
        }
        
        }
        catch (Exception e) {
            System.out.println("Exception in getTransaction as" + e.getMessage());
        }
        return null;
    
}
	public ArrayList<Transaction> listallTransactions() {
		ArrayList<Transaction>d=new ArrayList <Transaction>();
       	
        	for (Map.Entry<Integer,Transaction> entry : DataBase.getdb1().customerTransactions.entrySet()) 
          		d.add(entry.getValue());
          		 
        	         
        	return d;
        	 
	}
}
