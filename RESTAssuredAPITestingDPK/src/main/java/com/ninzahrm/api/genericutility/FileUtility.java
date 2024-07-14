package com.ninzahrm.api.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fin = new FileInputStream("./configEnvData/commondata.properties");
	
		Properties p = new Properties();
		p.load(fin);
		String data = p.getProperty(key);
		return data;
	}
	
}
