package com.example.fawry.service.AdminService;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.ServiceModel.Services;

@Service
public class AddService {
	public boolean addService(Services ser) {
		try {
			for (Services entry :  DataBase.getdb1().providersServices){
       		 if(entry.getserviceName().toLowerCase().equals(ser.getserviceName().toLowerCase())&&
       				 entry.getServiceProvider().toLowerCase().equals(ser.getServiceProvider().toLowerCase())) {
       			 return false; 
       		 }
			}
		        DataBase.getdb1().providersServices.add(ser);
		    }catch (Exception e) {
		            System.out.println("Exception in provider as" + e.getMessage());
		            return false;
		        }
		    return true;
	}
}
