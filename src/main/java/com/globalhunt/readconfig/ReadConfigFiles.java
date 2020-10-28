package com.globalhunt.readconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFiles {
	public Properties prop;

	public ReadConfigFiles() {
		File file = new File(System.getProperty("user.dir") + "\\Config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
