package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Orange extends Provider {
private static Orange v=null;
	private Orange() {	
	}
	private Orange(String name,ArrayList <String>fields) {
		this.name=name;
		
		this.fields=fields;
	}
	public static Orange getOrange(String name,ArrayList <String>fields)
	{
		if(v==null)
			v=new Orange(name,fields);
		return v;
	}
}
