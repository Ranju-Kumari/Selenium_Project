package com.mercurytoursflights.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author M1049131 
 * Purpose: Method to read the configuration properties file.
 *         
 */

public class ConfigProperty {

	public static Properties prop;

	public ConfigProperty() {
		File src = new File("./configuration.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
