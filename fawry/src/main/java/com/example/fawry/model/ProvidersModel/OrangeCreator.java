package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

public class OrangeCreator extends ProviderCreator {
	@Override
	public Provider creatProvider(String name,ArrayList <String>fields) {
		return Orange.getOrange(name,fields);
	}

}
