package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProviderCreator {
	
	public abstract Provider creatProvider(String name,ArrayList <String>fields);
}