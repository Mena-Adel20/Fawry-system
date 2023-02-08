package com.example.fawry.controller.AdminController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.fawry.model.Response;
import com.example.fawry.model.DiscountModel.OverAllDiscount;
import com.example.fawry.model.DiscountModel.SpecificDiscount;
import com.example.fawry.service.AdminService.AddDiscount;
import com.example.fawry.service.AdminService.AddProvider;
import com.example.fawry.service.AdminService.AdminRegistration;

@RestController
@RequestMapping("/AdddiscountController")
public class AdddiscountController {
	AddDiscount adddiscount=new AddDiscount();  
	AdminRegistration adminRegistration=new AdminRegistration();  

	 @PostMapping("/addoverAlldiscount/{name}/{pass}")
    public Response addoverAlldiscount(@RequestBody OverAllDiscount v ,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
     
        System.out.println("in add OverAllDiscount");
        Response response = new Response();
        boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

        boolean res = adddiscount.addDiscount(v);
        if (!res) {
            response.setStatus(false);
            response.setMessage("OverAllDiscount for this service Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("OverAllDiscount added to this service  successfully");
        return response;
    }
	 @PostMapping("/addSpecificdiscount/{name}/{pass}")
	    public Response Specificdiscount(@RequestBody SpecificDiscount v,@PathVariable ("pass") String pass,@PathVariable ("name") String name ) {
	     
	        System.out.println("in add Specific discount");
	        Response response = new Response();

	        boolean valid=adminRegistration.SignIn(name, pass);
			if(!valid)
			{
				 response.setStatus(false);
		            response.setMessage("invalid password or username");
		            response.object=null;
		            return response;
			}
	        boolean res = adddiscount.addDiscount(v);
	        if (!res) {
	            response.setStatus(false);
	            response.setMessage("Specificdiscount for this service Already Exists");
	            return response;
	        }

	        response.setStatus(true);
	        response.setMessage("Specificdiscount added to this service  successfully");
	        return response;
	    }

}
