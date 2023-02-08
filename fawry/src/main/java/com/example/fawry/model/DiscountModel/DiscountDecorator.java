package com.example.fawry.model.DiscountModel;



public abstract class DiscountDecorator  {
	
public String sername;
public double discount;
public String discountname;
public abstract String getsername();
public abstract double getdiscount() ;
public abstract void setdiscount(double discount) ;
public abstract void setsername(String s) ;
public abstract String getDiscountname() ;
public abstract void setdiscountname(String discountname) ;


	
}
