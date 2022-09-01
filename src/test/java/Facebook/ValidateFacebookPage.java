package Facebook;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.HomePage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class ValidateFacebookPage extends Base {
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
	public void ValidateHomePage() throws IOException, InterruptedException
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
		
		
	}
	

	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("AFterTest");
	}

}
