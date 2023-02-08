package com.example.fawry.model.ProvidersModel;

import java.util.ArrayList;

public class EtisalatCreator extends ProviderCreator {
	@Override
	public Provider creatProvider(String name,ArrayList <String>fields) {
		return Etisalat.getEtisalat(name,fields);
	}

}
