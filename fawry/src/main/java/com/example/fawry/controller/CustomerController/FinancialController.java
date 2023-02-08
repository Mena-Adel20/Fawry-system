package com.example.fawry.controller.CustomerController;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawry.database.DataBase;

import com.example.fawry.model.Response;


import com.example.fawry.model.PaymentModel.Cashe;
import com.example.fawry.model.PaymentModel.CreditCard;
import com.example.fawry.model.PaymentModel.Wallet;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.service.CustomerService.CustomerRegsration;
import com.example.fawry.service.CustomerService.FinancialService;
import com.example.fawry.service.CustomerService.SearchService;
@RestController
@RequestMapping("/FinancialController")
public class FinancialController {
	@Autowired
	FinancialService financialservice=new FinancialService();
	CustomerRegsration customerregistration=new CustomerRegsration();

	@PostMapping("/paywallet/{email}/{pass}")
    public Response PayWithWallet(@RequestBody Wallet wallet,@PathVariable ("pass") String pass,@PathVariable ("email") String email ) {
		System.out.println("in pay" + wallet);
		Response response = new Response();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int id= DataBase.getdb1().getcustid(a)+1;
	
		boolean res=financialservice.PayWithWallet(wallet,id,a);
		if (!res) {
            response.setStatus(false);
            response.setMessage("Incorrect service name or provider name");
            response.object=null;
            return response;
        }

        response.setStatus(true);
        response.setMessage("payment process with Wallet is successful");
        response.object=wallet;
        return response;
	}
	
	@PostMapping("/paycreditcard/{email}/{pass}")
    public Response paywithcreditcard(@RequestBody CreditCard creditcard,@PathVariable ("pass") String pass,@PathVariable ("email") String email ) {
		System.out.println("in pay with " + creditcard);
		Response response = new Response();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int id= DataBase.getdb1().getcustid(a)+1;

		boolean res=financialservice.PayWithCreditCard(creditcard,id,a);
		
		if (!res) {
            response.setStatus(false);
            response.setMessage("Incorrect service name or provider name");
            response.object=null;
            return response;
        }

        response.setStatus(true);
        response.setMessage("payment process with CreditCard is successful");
        response.object=creditcard;
        return response;
	}
	@PostMapping("/paycashe/{email}/{pass}")
    public Response paywithcreditcard(@RequestBody Cashe cashe,@PathVariable ("pass") String pass,@PathVariable ("email") String email) {
		System.out.println("in pay with " + cashe);
		Response response = new Response();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int id= DataBase.getdb1().getcustid(a)+1;

		boolean res=financialservice.PayWithCashe(cashe,id);
		if (!res) {
            response.setStatus(false);
            response.setMessage("Incorrect service name or provider name");
            response.object=null;
            return response;
        }

        response.setStatus(true);
        response.setMessage("payment process with Cashe is successful");
        response.object=cashe;
        return response;
	}
	@PostMapping("/addfundstowallet/{email}/{pass}")
    public Response addfundstowallet(@RequestBody CreditCard card,@PathVariable ("pass") String pass,@PathVariable ("email") String email) {
		System.out.println("in pay with " + card);
		Response response = new Response();
		Account a=customerregistration.SignIn(email, pass);
		if(a==null)
		{
			 response.setStatus(false);
	            response.setMessage("invalid email or username");
	            response.object=null;
	            return response;
		}
		int id= DataBase.getdb1().getcustid(a)+1;

		boolean res=financialservice.AddFundsToWallet(card,id,a);
		if (!res) {
            response.setStatus(false);
            response.setMessage("Write Wallet details in acorrect way");
            response.object=null;
            return response;
        }

        response.setStatus(true);
        response.setMessage("Add to Wallet process is successful");
        response.object=card;
        return response;
	}	
}
