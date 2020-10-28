package com.globalhunt.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver setDriver(String browser) {
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
		return driver;
	}
}
