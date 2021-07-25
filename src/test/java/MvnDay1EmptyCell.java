import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MvnDay1EmptyCell {
public static void main(String[] args) throws IOException {
	File file = new File("C:\\Users\\sasik\\eclipse-workspace\\FrameworkBatch8am\\INPUTFILE\\Day1Data.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook w = new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet1");
	Row r = s.getRow(4);
	int cellCount = r.getPhysicalNumberOfCells();
	System.out.println("Number of Empty Cell with empty cell - "+cellCount);
}
}
