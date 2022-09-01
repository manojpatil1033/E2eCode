package Academy;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class ValidateNavigationBars extends Base {
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(ValidateNavigationBars.class.getName());
	
	@BeforeTest
	public void InizialiseBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("BeforeTest");
	}
	
	@Test
	public void ValidateNavigation() throws IOException, InterruptedException
	{
//		driver=initializeDriver();
//		driver.get(prop.getProperty("url"));
		Thread.sleep(9000);
		driver.switchTo().alert().dismiss();
		
		//Actions act =  new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//button[text()='NO THANKS']"))).click().perform();
		//driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();
		LandingPage l=new LandingPage(driver);
		
		AssertJUnit.assertTrue(l.navBarOption().isDisplayed());
		log.info("Validation is Successfull of ValidationNavigation Testcases");
		
		
		
		
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("AFterTest");
	}

}
