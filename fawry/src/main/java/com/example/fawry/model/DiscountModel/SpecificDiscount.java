package com.example.fawry.model.DiscountModel;


public class SpecificDiscount extends DiscountDecorator  {
	@Override
	public String getsername() {
		
		return this.sername;
	}

	@Override
	public double getdiscount() {
	
		return this.discount;
	}

	@Override
	public void setdiscount(double discount) {
		this.discount=discount;
		
	}

	@Override
	public void setsername(String s) {
		this.sername=s;
		
	}

	@Override
	public String getDiscountname() {
		return this.discountname;
	}

	@Override
	public void setdiscountname(String discountname) {

		this.discountname=discountname;
	}

}
