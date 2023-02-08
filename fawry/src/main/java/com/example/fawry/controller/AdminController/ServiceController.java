package com.example.fawry.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawry.model.Response;
import com.example.fawry.model.ServiceModel.Donations;
import com.example.fawry.model.ServiceModel.InternetPaymentServices;
import com.example.fawry.model.ServiceModel.LandlineServices;
import com.example.fawry.model.ServiceModel.MonthlyReceipt;
import com.example.fawry.model.ServiceModel.QuarterReceipt;
import com.example.fawry.model.ServiceModel.mobileRechargeService;
import com.example.fawry.service.AdminService.AddService;
import com.example.fawry.service.AdminService.AdminRegistration;
@RestController
@RequestMapping("/ServiceController")
public class ServiceController {
	@Autowired
	AddService addService=new AddService();  
	AdminRegistration adminRegistration=new AdminRegistration();  

	 @PostMapping("/addmobileRechargeService/{name}/{pass}")
     public Response addService(@RequestBody mobileRechargeService service,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
   
          System.out.println("in add service" + service);
          Response response = new Response();
          boolean valid=adminRegistration.SignIn(name, pass);
  		if(!valid)
  		{
  			 response.setStatus(false);
  	            response.setMessage("invalid password or username");
  	            response.object=null;
  	            return response;
  		}

          boolean res = addService.addService(service);
         if (!res) {
              response.setStatus(false);
              response.setMessage("Service Already Exists");
              return response;
          }

          response.setStatus(true);
          response.setMessage("Service added successfully");
          return response;
      }
  @PostMapping("/addInternetPaymentServices/{name}/{pass}")
  public Response addService(@RequestBody InternetPaymentServices service,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {

       System.out.println("in add service" + service);
       Response response = new Response();
       boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

       boolean res = addService.addService(service);
      if (!res) {
           response.setStatus(false);
           response.setMessage("Service Already Exists");
           return response;
       }

       response.setStatus(true);
       response.setMessage("Service added successfully");
       return response;
   }
  @PostMapping("/addDonations/{name}/{pass}")
  public Response addService(@RequestBody Donations service,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {

       System.out.println("in add service" + service);
       Response response = new Response();
       boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

       boolean res = addService.addService(service);
      if (!res) {
           response.setStatus(false);
           response.setMessage("Service Already Exists");
           return response;
       }

       response.setStatus(true);
       response.setMessage("Service added successfully");
       return response;
   }

  @PostMapping("/addQuarterReceipt/{name}/{pass}")
  public Response addService(@RequestBody QuarterReceipt service,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {

       System.out.println("in add service" + service);
       Response response = new Response();
       boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

       boolean res = addService.addService(service);
      if (!res) {
           response.setStatus(false);
           response.setMessage("Service Already Exists");
           return response;
       }

       response.setStatus(true);
       response.setMessage("Service added successfully");
       return response;
   }
  @PostMapping("/addMonthlyReceipt/{name}/{pass}")
  public Response addService(@RequestBody MonthlyReceipt service,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {

       System.out.println("in add service" + service);
       Response response = new Response();
       boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

       boolean res = addService.addService(service);
      if (!res) {
           response.setStatus(false);
           response.setMessage("Service Already Exists");
           return response;
       }

       response.setStatus(true);
       response.setMessage("Service added successfully");
       return response;
   }
}
