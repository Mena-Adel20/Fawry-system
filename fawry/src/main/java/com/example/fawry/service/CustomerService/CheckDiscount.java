package com.example.fawry.service.CustomerService;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.fawry.database.DataBase;
import com.example.fawry.model.DiscountModel.DiscountDecorator;
@Service
public class CheckDiscount {
	public ArrayList<DiscountDecorator> CheckDiscount(String ser) {
        try {
        	ArrayList<DiscountDecorator>d=new ArrayList <DiscountDecorator>();
        	 for (DiscountDecorator discount : DataBase.getdb1().discounts )  {
				 if(ser.equals(discount.getsername())) {
					  d.add(discount);
					 }
				 }
        	 return d;
        } catch (Exception e) {
            System.out.println("Exception in getCustomer as" + e.getMessage());
        }
        return null;
    }
}
