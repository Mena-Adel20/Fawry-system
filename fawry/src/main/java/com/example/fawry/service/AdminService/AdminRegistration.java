package com.example.fawry.service.AdminService;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.RegistrationModel.Account;

@Service
public class AdminRegistration {
    public boolean SignIn(String em,String pass) {
        try {        		
        	 
        		if(DataBase.getdb1().getAdminName().equals(em)&& DataBase.getdb1().getAdminPassword().equals(pass))
        			return true;
        	
        	
           
        } catch (Exception e) {
            System.out.println("Exception in getCustomer as" + e.getMessage());
        }
        return false;
    }
}
