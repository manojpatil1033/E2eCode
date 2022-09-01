package Academy;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

public class ValidateTitle extends Base {
	public WebDriver driver;
	
	
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void InizialiseBrowser() throws IOException
	{
		driver=initializeDriver();
		log.info("Drive is Inizilised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Application url");
		System.out.println("BeforeTest");
	}
	
	
	@Test
	public void navigatePage() throws IOException, InterruptedException
	{
//		driver=initializeDriver();
//		driver.get(prop.getProperty("url"));
		Thread.sleep(9000);
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("NO THANKS"))).click().perform();
		//driver.findElement(By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle'])[6]")).click();
		LandingPage l=new LandingPage(driver);
		
		String expValue=l.getTitle().getText();
		log.debug("getting Expected title Value");
		Assert.assertEquals(expValue, "FEATURED COURSES");
		log.info("Validation is Successfull for navigationPageTestcases");
		
		
		
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("AFterTest");
	}

}
