package com.example.fawry.service.CustomerService;

import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.RegistrationModel.Account;


@Service
public class CustomerRegsration {

	public Boolean SignUP(Account a) {
        try {
        	if( DataBase.getdb1().ValidateSignUp(a)) {
			       DataBase.getdb1().cust_accounts.put(Account.custid++, a);
			       a.wallet.setBalance(a.getWalletbalance());
			       a.credit.setCardBalance(a.getCardbalance());
			   
			    
			       
			    
			       return true;
        	}
        	else 
        		return false;

 
        } catch (Exception e) {
            System.out.println("Exception in account as" + e.getMessage());
            return false;
        }
      
    }
	public Account SignIn(String em,String pass) {
        try {	
        	if(DataBase.getdb1().ValidateSignIn( em, pass)!=null) {
        			return DataBase.getdb1().ValidateSignIn( em, pass);
        		        	
        	}
           
        } catch (Exception e) {
            System.out.println("Exception in getCustomer as" + e.getMessage());
        }
        return null;
    }
}
