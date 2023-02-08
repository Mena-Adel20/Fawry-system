package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

public class VodafoneCreator extends ProviderCreator {

	@Override
	public Provider creatProvider(String name,ArrayList <String>fields) {
		return Vodafone.getvodafone( name,fields);
	}

}
