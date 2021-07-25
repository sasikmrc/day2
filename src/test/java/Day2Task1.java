import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Task1 {
	public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
	Thread.sleep(3000);
	driver.manage().window().maximize();
	WebElement dDnCountries = driver.findElement(By.xpath("//select[@id='countries']"));
	Select select = new Select(dDnCountries);
	List<WebElement> alloption = select.getOptions();
	String name = null;
	File f = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Website.xlsx");
	Workbook w = new XSSFWorkbook();
	Sheet s = w.createSheet("Sheet New");
	
//	for (WebElement x : alloption) {
//		String text = x.getText();
//		System.out.println(text);
		
		
		for (int i = 0; i < alloption.size(); i++) {
			WebElement wb = alloption.get(i);
			name = wb.getText();
			Row r = s.createRow(i);
			Cell cell = r.createCell(0);
			cell.setCellValue(name);
	
			
			FileOutputStream o = new FileOutputStream(f);
			w.write(o);
			System.out.println("Done Over ....");
			
			
		}
		
	}
	}



