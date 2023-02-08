package com.example.fawry.controller.AdminController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fawry.model.TransactionModel.Transaction;
import com.example.fawry.service.AdminService.AdminRegistration;
import com.example.fawry.service.AdminService.ListTransaction;

@RestController
@RequestMapping("/ListTransactionController")
public class ListTransactionController {
	@Autowired
	ListTransaction transactions=new ListTransaction();	
	AdminRegistration adminRegistration=new AdminRegistration();  

	
	@GetMapping("/paymenttransactions/{type}/{name}/{pass}")
	public ArrayList<Transaction> getPaymentTransactions(@PathVariable("type") String type,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
        System.out.println("get All Transactions");
        boolean valid=adminRegistration.SignIn(name, pass);
		if(valid)
		{
        return transactions.listTransactions(type);
		}
		return null;
    }
	
	@GetMapping("/refundtransactions/{type}/{name}/{pass}")
	public ArrayList<Transaction> getRefunTransactions(@PathVariable("type") String type,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
        System.out.println("get All Transactions");
        boolean valid=adminRegistration.SignIn(name, pass);
		if(valid)
		{
	        return transactions.listTransactions(type);
		}
		return null;
    }
	
	@GetMapping("/wallettransactions/{type}/{name}/{pass}")
	public ArrayList<Transaction> getWalletTransactions(@PathVariable("type") String type,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
        System.out.println("get All Transactions");
        boolean valid=adminRegistration.SignIn(name, pass);
		if(valid)
		{
	        return transactions.listTransactions(type);
		}
		return null;
    }
	@GetMapping("/alltransaction/{name}/{pass}")
	public ArrayList<Transaction> getallTransactions(@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
        System.out.println("get All Transactions");
        boolean valid=adminRegistration.SignIn(name, pass);
		if(valid)
		{
	        return transactions.listallTransactions();
		}
		return null;
    }
	
	
}
