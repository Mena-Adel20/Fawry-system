package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

public class We extends Provider {
private static We v=null;

	private We() {	
	}
	private We(String name,ArrayList <String>fields) {
    	this.name=name;
		this.fields=fields;
	}
	public static We getWe(String name,ArrayList <String>fields)
	{
		if(v==null)
			v=new We(name,fields);
		return v;
	}
}
