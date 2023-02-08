package com.example.fawry.controller.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.Response;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.model.TransactionModel.Transaction;
import com.example.fawry.service.CustomerService.CustomerRegsration;
import com.example.fawry.service.CustomerService.Refund;
@RestController
@RequestMapping("/RefundController")
public class RefundController {
	@Autowired
	Refund refund=new Refund();
	CustomerRegsration customerregistration=new CustomerRegsration();

	@GetMapping("/askForRefund/{id}/{email}/{pass}")
    public  Response <Transaction> askForRefund(@PathVariable ("id") int transactionId,@PathVariable ("pass") String pass,@PathVariable ("email") String email) {
		System.out.println("in ask for refund " + transactionId);
		Response<Transaction> response = new Response<Transaction>();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int id= DataBase.getdb1().getcustid(a)+1;

		Transaction res=refund.askForRefund(transactionId,id);
		if (res==null) {
            response.setStatus(false);
            response.setMessage("Wrong Transaction ID.Try to rewrite it");
            response.object=null;
            return response;
        }

        response.setStatus(true);
        response.setMessage("Your refund has been sent.Wait for a response");
        response.object=res;
        return response;
	}
	
	@GetMapping("/CheckRefund/{id}/{email}/{pass}")
    public  Response  CheckRefund(@PathVariable ("id") int transactionId,@PathVariable ("pass") String pass,@PathVariable ("email") String email) {
		System.out.println("in ask for refund " + transactionId);
		Response response = new Response();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int res=refund.CheckRefund(transactionId);
		if (res==0) {
            response.setStatus(false);
            response.setMessage("Your refund request has been rejected");
            return response;
        }
		else if(res==-1) {
			 response.setStatus(false);
	            response.setMessage("Your refund request is in waitaing list");
	            return response;
		}
		
        response.setStatus(true);
        response.setMessage("Your refund request has been accepted");
        return response;
	}
	
}
