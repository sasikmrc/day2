package org.method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
	public static void main(String[] args) {
		LibGlobalCommon libGlobal = new LibGlobalCommon();
		WebDriver driver = libGlobal.getDriver();
		libGlobal.loadUrl("https://www.flipkart.com/");
		libGlobal.maximize();
		WebElement txtUserName = driver.findElement(By.id("email"));
		libGlobal.type(txtUserName, "sasi.kmrc@gmail.com");
		
		WebElement txtpassword = driver.findElement(By.id("pass"));
		libGlobal.type(txtpassword, "!!@#$$$");
		
		WebElement btnlogin = driver.findElement(By.id("pass"));
			libGlobal.clcik(btnlogin);
			WebElement lnkcourse = driver.findElement(By.xpath("//a[text"));
	}
	
	

}
