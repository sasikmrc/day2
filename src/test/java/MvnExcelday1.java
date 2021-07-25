import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MvnExcelday1 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Day1Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook xssfWorkbook = new XSSFWorkbook(stream);
		Sheet s = xssfWorkbook.getSheet("Sheet1");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				System.out.println(c);
				
			}
		}
	}

}
