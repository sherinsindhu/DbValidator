package com.abc.validator.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Utility {
	
	public static Properties loadProperties(String fileName) {
		Properties property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(fileName);
            property.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Where is your  config file ?");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property;
	}
	
}
