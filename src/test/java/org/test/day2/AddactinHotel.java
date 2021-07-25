package org.test.day2;

import java.io.IOException;

import org.method.LibGlobalCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddactinHotel {
	WebDriver driver;

	public void login(String userName, String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(userName); 
		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys(password);
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		// TakeScreenShot screenShot1 = (TakeScreenShot)driver;
		Thread.sleep(5000);
	}

	public void searchHotel(String name1, String name2, String text) throws InterruptedException {
		WebElement dpLocation = driver.findElement(By.id("location"));
		Select select = new Select(dpLocation);
		select.selectByVisibleText(name1);
		WebElement dphotels = driver.findElement(By.id("hotels"));
		Select select1 = new Select(dphotels);
		select1.selectByVisibleText(name2);
		WebElement dproomtype = driver.findElement(By.id("room_type"));
		Select select2 = new Select(dproomtype);
		select2.selectByVisibleText(text);
		WebElement btnClick1 = driver.findElement(By.id("Submit"));
		btnClick1.click();
		Thread.sleep(5000);
	}

	public void selectHotel() throws InterruptedException {
		WebElement rdbtn = driver.findElement(By.name("radiobutton_0"));
		rdbtn.click();
		WebElement btn = driver.findElement(By.name("continue"));
		btn.click();
		Thread.sleep(5000);
	}

	public void bookHotel(String firstName, String lastName, String address, String CcNo, String text, String text1,
			String year, String cvv) throws InterruptedException {
		WebElement txtFirstName = driver.findElement(By.name("first_name"));
		txtFirstName.sendKeys(firstName);
		WebElement txtlastName = driver.findElement(By.name("last_name"));
		txtlastName.sendKeys(lastName);
		WebElement txtAddress = driver.findElement(By.name("address"));
		txtAddress.sendKeys(address);
		WebElement numCcNo = driver.findElement(By.name("cc_num"));
		numCcNo.sendKeys(CcNo);

		WebElement dpcctype = driver.findElement(By.id("cc_type"));
		Select select2 = new Select(dpcctype);
		select2.selectByVisibleText(text);

		WebElement dpccexpmm = driver.findElement(By.id("cc_exp_month"));
		Select select3 = new Select(dpccexpmm);
		select3.selectByVisibleText(text1);

		WebElement dpccexpyy = driver.findElement(By.id("cc_exp_year"));
		Select select4 = new Select(dpccexpyy);
		select4.selectByVisibleText(year);

		WebElement txtcvv = driver.findElement(By.name("cc_cvv"));
		txtcvv.sendKeys(cvv);

		WebElement btn = driver.findElement(By.name("book_now"));
		btn.click();

	}

	public String bookingConfrim() throws InterruptedException, IOException {

		WebElement element = driver.findElement(By.id("order_no"));
		String name1 = element.getAttribute("value");
		Thread.sleep(3000);
		LibGlobalCommon.updateDataIntoExcel(name1);

		return name1;

	}
}
