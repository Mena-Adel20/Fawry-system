package com.example.fawry.service.CustomerService;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.ServiceModel.Services;


@Service
public class SearchService {
		 public ArrayList<Services> SearchServices(String description) {
		        try {
		        	ArrayList<Services> services=new ArrayList<Services>();
		        	if(DataBase.getdb1().validateService( description)) {
		        	for (Services entry :  DataBase.getdb1().providersServices) {

		        		if(entry.getserviceName().toLowerCase().equals( description.toLowerCase()) )
		        			services.add(entry);	        	
		        	}
		        	return services;
		       }
		        } catch (Exception e) {
		            System.out.println("Exception in getCustomer as" + e.getMessage());
		        }
		        return null;
		 }
}
