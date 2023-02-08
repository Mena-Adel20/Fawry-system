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
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.service.CustomerService.CustomerRegsration;
import com.example.fawry.service.CustomerService.SearchService;

@RestController
@RequestMapping("/CustomerRegstrationController")
public class CustomerRegstrationController {
	@Autowired
	CustomerRegsration customerregistration=new CustomerRegsration();
	@PostMapping("/signup")
    public Response signup(@RequestBody Account a) {
        System.out.println("In Add Customer" + a);
        boolean res = customerregistration.SignUP(a);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("Customer UserName or Email Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Customer Account created successfully");
        response.object=a;
        return response;
    }
 @GetMapping("/signin/{pass}/{email}")
    public Response<Account> signin(@PathVariable("pass") String pass,@PathVariable("email") String email) {
        var customer = customerregistration.SignIn(email,pass);
        Response<Account> response = new Response<Account>();
        if (customer == null ) {
        	response.setStatus(false);
            response.setMessage("Customer Account Not Found");
            response.object = null;

	        return response;
        }
        response.setStatus(true);
        response.setMessage("Customer Sign in Successfully");
        response.object = customer;

     return response;

        
    }
}
