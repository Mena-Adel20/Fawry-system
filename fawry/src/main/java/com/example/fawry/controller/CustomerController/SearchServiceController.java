package com.example.fawry.controller.CustomerController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawry.model.Response;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.model.ServiceModel.Services;
import com.example.fawry.service.CustomerService.CustomerRegsration;
import com.example.fawry.service.CustomerService.SearchService;

@RestController
@RequestMapping("/SearchServiceController")
public class SearchServiceController {
	@Autowired
	SearchService searchservice=new SearchService();
	CustomerRegsration customerregistration=new CustomerRegsration();

	@GetMapping("/searchservice/{description}/{email}/{pass}")
    public ArrayList<Services> searchService(@PathVariable("description") String description,@PathVariable ("pass") String pass,@PathVariable ("email") String email) {
        Account a=customerregistration.SignIn(email, pass);
		if(a!=null)
		{
	        return  searchservice.SearchServices(description);  
		}
        return null;
    }
}
