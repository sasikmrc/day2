import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MvngapDataDay1 {
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Day1Data.xlsx");
	FileInputStream stream = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet1");
	Row row = s.getRow(4);
	Cell c = row.getCell(11);
	System.out.println(c);
	
}
}
