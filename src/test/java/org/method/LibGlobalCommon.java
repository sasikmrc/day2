package org.method;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobalCommon {
	public static WebDriver driver;

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void loadUrl(String url) {
		driver.get(url);

	}

	public void maximize() {
		driver.manage().window().maximize();

	}

	public String elementText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public void type(WebElement element, String data) {
		element.sendKeys(data);

	}

	public void clcik(WebElement element) {
		element.click();

	}

	public void presentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public void urlNavigate(String url1) {
		driver.navigate().to(url1);

	}

	public void urlNavigateforward(String url2) {
		driver.navigate().forward();
	}

	public void urlNavigateback(String url3) {
		driver.navigate().back();
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public void toClose() {
		driver.quit();

	}

	public boolean toCheckSelection(WebElement element1, boolean b) {
		return element1.isSelected();
	}

	public void mouseActionmove(WebElement lnkcourse, WebElement element1, String name1) {
		Actions actions = new Actions(driver);
		actions.moveToElement(lnkcourse).perform();
		element1.click();
	}

	public void rightClick(WebElement btnClick) {
		Actions actions = new Actions(driver);
		actions.contextClick(btnClick).perform();
	}

	public void doubleClick(WebElement btnClick) {
		Actions actions = new Actions(driver);
		actions.doubleClick(btnClick).perform();
	}

	public void keyAction() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void DoubleClick(WebElement select) {
		Actions actions = new Actions(driver);
		actions.doubleClick(select).perform();
	}

	public void keyDownUp(WebElement txtUserName, String name) {
		Actions actions = new Actions(driver);
		actions.keyDown(txtUserName, Keys.SHIFT).sendKeys(txtUserName, name).keyUp(txtUserName, Keys.SHIFT).perform();
	}

	public TargetLocator switchToField() {
		return driver.switchTo();
	}

	public Alert switchToAlert() {
		return switchToField().alert();
	}

	public void alertAccept() {

		switchToAlert().accept();
	}

	public void alertDismiss() {
		switchToAlert().dismiss();
	}

	public void alertSendKeys(String name) {
		switchToAlert().sendKeys(name);
		switchToAlert().accept();
	}

	public String alertGetText(String name) {
		Alert al = switchToField().alert();
		return al.getText();
	}

	public void dropDownIndex(WebElement element, int a) {
		new Select(element).selectByIndex(a);
	}

	public void dropDownValue(WebElement element, String name1) {
		new Select(element).selectByValue(name1);
	}

	public void dropDownVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public String dropDownGetOptions(WebElement element, int a) {
		Select select = new Select(element);
		List<WebElement> allOpt = select.getOptions();
		WebElement element2 = allOpt.get(a);
		return elementText(element2);
	}

	public String dropDownallOptions(WebElement element, int a) {
		Select select = new Select(element);
		List<WebElement> allOpt = select.getAllSelectedOptions();
		WebElement element2 = allOpt.get(a);
		return elementText(element2);
	}

	public String dropDownFirstOptions(WebElement element, int a) {
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String text = elementText(option);
		return text;

	}

	public String excelRead(int rowNo, int cellNo) throws IOException, InterruptedException {
		String name = null;
		File file = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Test Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		if (type == 1) {
			name = c.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(c)) {
			Date date = c.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			name = dateFormat.format(date);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			name = String.valueOf(l);

		}

		return name;

	}

	public static void updateDataIntoExcel(String name) throws IOException {
		File file = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Test Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r1 = s.getRow(1);
		Cell c1 = r1.createCell(14);
		String name2 = c1.getStringCellValue();
		if (name2.equals("")) {
			c1.setCellValue(name);
		}

		FileOutputStream out = new FileOutputStream(
				"C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Test Data.xlsx");
		w.write(out);
	}
}
