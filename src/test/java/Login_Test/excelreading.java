package Login_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelreading {

	public static void main(String[] args) throws IOException {
		FileInputStream file= new FileInputStream("D:/selenium/Excel file/Letcode_login.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		int cellcount=sheet.getRow(0).getLastCellNum();

	}

}
