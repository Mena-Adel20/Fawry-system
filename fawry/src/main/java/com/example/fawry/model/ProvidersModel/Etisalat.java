package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

public class Etisalat extends Provider {
private static Etisalat v=null;

	private Etisalat() {
		
	}
    private Etisalat(String name,ArrayList <String>fields) {
    	this.name=name;
	
		this.fields=fields;
	}
	public static Etisalat getEtisalat(String name,ArrayList <String>fields)
	{
		if(v==null)
			v=new Etisalat(name,fields);
		return v;
	}
}
