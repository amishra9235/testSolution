package com.globalhunt.stepfiles;

import com.globalhunt.base.BaseSetUp;
import com.globalhunt.base.Browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseSetUp {

	@Before("@Chrome")
	public void launchChrome() {
		driver = Browser.setDriver("chrome");

	}

	@Before("@Firefox")
	public void launchFirefox() {
		driver = Browser.setDriver("firefox");

	}

	@After()
	public void quitBrowser() {
		driver.quit();
	}

}
