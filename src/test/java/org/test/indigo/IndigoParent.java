package org.test.indigo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndigoParent {
	
		
	
WebDriver driver1;
public void booking(String fromLocation) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver1 = new ChromeDriver();
	driver1.get("https://www.goindigo.in/flight-booking.html");
	Thread.sleep(4000);
	driver1.manage().window().maximize();
	WebElement element = driver1.findElement(By.xpath("//input[@name='or-src']"));
	Select select = new Select(element);
	select.selectByValue("fromLocation");
		
	
	
	
}	


}
