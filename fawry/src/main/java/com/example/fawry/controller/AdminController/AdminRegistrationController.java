package com.example.fawry.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.fawry.model.Response;
import com.example.fawry.model.RegistrationModel.Account;
import com.example.fawry.service.AdminService.AdminRegistration;
@RestController
@RequestMapping("/AdminRegistrationController")
public class AdminRegistrationController {
	@Autowired
	AdminRegistration adminRegistration=new AdminRegistration();  
 @GetMapping("/signin/{pass}/{name}")
    public Response signin(@PathVariable("pass") String pass,@PathVariable("name") String name) {
        boolean admin = adminRegistration.SignIn(name,pass);
        Response response = new Response();
        if (!admin ) {
        	response.setStatus(false);
            response.setMessage("invalid username or password");
 
	        return response;
        }
        response.setStatus(true);
        response.setMessage("Admin Sign in Successfully");

     return response;


    }
}
