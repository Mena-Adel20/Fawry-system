package com.example.fawry.service.AdminService;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.ProvidersModel.Provider;

@Service
public class AddProvider {
	public boolean addProvider(Provider p) {
	    try {
	     if( DataBase.getdb1().validateProvider(p.getName())) {
	        DataBase.getdb1().providers.put(p.getName().toLowerCase(),p);
	        return true;
	     }
	     return false;
	    }catch (Exception e) {
	            System.out.println("Exception in provider as" + e.getMessage());
	            return false;
	        }
	  }
}
