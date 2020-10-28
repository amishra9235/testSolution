package com.globalhunt.base;

import org.openqa.selenium.WebDriver;

import com.globalhunt.readconfig.ReadConfigFiles;

public class BaseSetUp {
	public static WebDriver driver = null;
	public ReadConfigFiles config = new ReadConfigFiles();
	public String url = config.prop.getProperty("url");
	public int lowWaitTime = Integer.parseInt(config.prop.getProperty("lowWaitTime"));
	public int mediumWaitTime = Integer.parseInt(config.prop.getProperty("MediumWaitTime"));;
	public int highWaitTime = Integer.parseInt(config.prop.getProperty("HighWaitTime"));;

}
