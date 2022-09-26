package Login_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class excel_reading {
	
	List<String> userlist=new ArrayList<String>();
	List<String> passwordlist=new ArrayList<String>();
	WebDriver driver;
	
	public void excelreading() throws IOException 
	{
		FileInputStream file= new FileInputStream("D:/selenium/Excel file/Letcode_login.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheetAt(0);
		Iterator<Row>rowiterator=sheet.iterator();
		while(rowiterator.hasNext())
		{
			Row rowvalue=rowiterator.next();
			
			Iterator<Cell>celliterator=rowvalue.cellIterator();
			int i=2;
			while(celliterator.hasNext())
			{
				if(i%2==0)
				{
					userlist.add(celliterator.next().getStringCellValue()) ;
				}
				else {
					passwordlist.add(celliterator.next().getStringCellValue();
				}
				
				
			}
		}
	}
	
	 
	 
	@Test(dataProvider="loginvalue")
	  public void bothcorrect_uname_password(String email,String password) throws InterruptedException
	     {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://letcode.in/");
		driver.findElement(By.xpath("//*[@id=\"navbar-menu\"]/div[2]/div/div/a[2]")).click();
		
		WebElement uname=driver.findElement(By.name("email"));
		uname.sendKeys(email);
		
		WebElement upassword=driver.findElement(By.name("password"));
		upassword.sendKeys(password);
		
		driver.findElement(By.xpath("/html/body/app-root/app-signin/div/div/div/div/form/div[3]/p/button")).click();
		
		Thread.sleep(9000);
	    driver.findElement(By.xpath("//*[@id=\"navbar-menu\"]/div[2]/div/div/a")).click();
	    
	    driver.close();
	    }
   
	public static  void main(String[]args)
	{
		DataDrivernUsingPOI datadriven=new DataDrivernUsingPOI();
	}
}
