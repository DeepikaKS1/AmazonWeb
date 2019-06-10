package com.amazon.dataprovider;
import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.amazon.InputDataPojo.ValidLogin;
import com.amazon.InputDataPojo.WebConfig;
import com.amazon.constants.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CredentialsDataProvider {
	public static ObjectMapper mapper = new ObjectMapper();
	public static WebConfig webConfig = new WebConfig();
	
	@DataProvider(name="ValidLogin")
	public static final Object[][] getValidLoginDetails(){
		try {
			webConfig=mapper.readValue(new File(Constants.CONFIG_PATH), WebConfig.class);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		List<ValidLogin> data = webConfig.getValidLogin();
		
		Object [][] testData = new Object[data.size()][1];
		int i=0;
		for(Object[] data1:testData) {
			data1[0] = data.get(i++);	
		}
		return testData;
	}

}
