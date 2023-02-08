package com.example.fawry.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fawry.model.Response;
import com.example.fawry.model.ProvidersModel.Etisalat;
import com.example.fawry.model.ProvidersModel.Orange;
import com.example.fawry.model.ProvidersModel.Vodafone;
import com.example.fawry.model.ProvidersModel.We;
import com.example.fawry.service.AdminService.AddProvider;
import com.example.fawry.service.AdminService.AdminRegistration;
@RestController
@RequestMapping("/ProviderController")
public class ProviderController {
	@Autowired
	AddProvider addProvider=new AddProvider();  
	AdminRegistration adminRegistration=new AdminRegistration();  

	 @PostMapping("/addVodafone/{name}/{pass}")
     public Response addProvider(@RequestBody Vodafone v,@PathVariable ("pass") String pass,@PathVariable ("name") String name ) {
      
         System.out.println("in add provider");    
         Response response = new Response();
         boolean valid=adminRegistration.SignIn(name, pass);
 		if(!valid)
 		{
 			 response.setStatus(false);
 	            response.setMessage("invalid password or username");
 	            response.object=null;
 	            return response;
 		}


         boolean res = addProvider.addProvider(v);
         if (!res) {
             response.setStatus(false);
             response.setMessage("Vodafone Provider Already Exists");
             return response;
         }

         response.setStatus(true);
         response.setMessage("Vodafone Provider created successfully");
         return response;
     }
  @PostMapping("/addOrange/{name}/{pass}")
  public Response addProvider(@RequestBody Orange o,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
   
      System.out.println("in add provider");
      Response response = new Response();
      boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

      boolean res = addProvider.addProvider(o);
      if (!res) {
          response.setStatus(false);
          response.setMessage("Orange Provider Already Exists");
          return response;
      }

      response.setStatus(true);
      response.setMessage("Orange Provider created successfully");
      return response;
  }
  @PostMapping("/addEtisalat/{name}/{pass}")
  public Response addProvider(@RequestBody Etisalat e,@PathVariable ("pass") String pass,@PathVariable ("name") String name ) {
   
      System.out.println("in add provider");
      Response response = new Response();
      boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

      boolean res = addProvider.addProvider(e);
      if (!res) {
          response.setStatus(false);
          response.setMessage("Etisalat Provider Already Exists");
          return response;
      }

      response.setStatus(true);
      response.setMessage("Etisalat Provider created successfully");
      return response;
  }
  @PostMapping("/addWe/{name}/{pass}")
  public Response addProvider(@RequestBody We w,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
   
      System.out.println("in add provider");
      Response response = new Response();
      boolean valid=adminRegistration.SignIn(name, pass);
		if(!valid)
		{
			 response.setStatus(false);
	            response.setMessage("invalid password or username");
	            response.object=null;
	            return response;
		}

      boolean res = addProvider.addProvider(w);
      if (!res) {
          response.setStatus(false);
          response.setMessage("We Provider Already Exists");
          return response;
      }

      response.setStatus(true);
      response.setMessage("We Provider created successfully");
      return response;
  }
}
