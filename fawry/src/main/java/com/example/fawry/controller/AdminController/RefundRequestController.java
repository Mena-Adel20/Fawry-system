package com.example.fawry.controller.AdminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fawry.model.Response;
import com.example.fawry.service.AdminService.AdminRegistration;
import com.example.fawry.service.AdminService.RefundRequestService;

@RestController
@RequestMapping("/RefundRequestController")
public class RefundRequestController {
	 @Autowired
	 RefundRequestService refundRequestService=new RefundRequestService();
		AdminRegistration adminRegistration=new AdminRegistration();  

	@GetMapping("/acceptRefund/{id}/{name}/{pass}")
    public Response acceptRefund(@PathVariable ("id") int id,@PathVariable ("pass") String pass,@PathVariable ("name") String name ) {
     
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

        boolean res = refundRequestService.acceptRefund(id);
        if (!res) {
            response.setStatus(false);
            response.setMessage("Incorrect transaction ID");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Transaction with corresponding ID has been accepted");
        return response;
    }
	
	@GetMapping("/rejectRefund/{id}/{name}/{pass}")
    public Response rejectRefund(@PathVariable ("id") int id ,@PathVariable ("pass") String pass,@PathVariable ("name") String name) {
     
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

        boolean res = refundRequestService.rejectRefund(id);
        if (!res) {
            response.setStatus(false);
            response.setMessage("Incorrect transaction ID");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Transaction with corresponding ID has been declined");
        return response;
    }
	
}
