package Login_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upasswordcorrect {
	WebDriver driver;
	 
	 @Test
	 @Parameters({"Usermail","Userpassword"})
	  public void wrong_uname_correct_password(String email,String password) throws InterruptedException
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

}
