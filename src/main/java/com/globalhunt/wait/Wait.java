package com.globalhunt.wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static WebElement explicitWait(WebDriver driver, WebElement element, int waitTime) {

		return new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement explicitWait(WebDriver driver, By locator, int waitTime) {

		return new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static Alert waitForAlert(WebDriver driver, int waitTime) {

		return new WebDriverWait(driver, waitTime).until(ExpectedConditions.alertIsPresent());
	}

}
