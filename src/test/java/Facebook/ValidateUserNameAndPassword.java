package Facebook;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Smoke Testcases
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Academy.HomePage;
import Resources.Base;

public class ValidateUserNameAndPassword extends Base {
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void InizialiseBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url1"));
		System.out.println("BeforeTest");
	}
	
	
	
	
	@Test
	public void EnterUserNameAndPassword() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Manoj@123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
		
	}
	

	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("AFterTest");
	}


}
