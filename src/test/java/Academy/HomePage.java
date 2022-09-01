package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	private static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void InizialiseBrowser() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("BeforeTest");
	}
	
	
	
	
	@Test(dataProvider = "dataValues")
	public void navigatePage(String userName,String Password) throws IOException, InterruptedException
	{
		Thread.sleep(9000);
		Actions act =  new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("NO THANKS"))).click().perform();
		LandingPage l=new LandingPage(driver);
		
		l.getLoginDirectButton().click();
		
		//Performing Loging operation on Login Page
		
		LoginPage lp=new LoginPage(driver);
		lp.getUserName().sendKeys(userName);
		lp.getPassword().sendKeys(Password);
		lp.getLoginButton().click();
		log.info("Successfull Tap on Login Button");
		
		
		
	}
	
	@DataProvider
	public Object[][] dataValues()
	{
		Object[][] ob=new Object[1][2];
		ob[0][0]="restricteduser@gmail.com";
		ob[0][1]="Pass@123";
//		ob[1][0]="Nonrestricteduser@gmail.com";
//		ob[1][1]="Pass@123";
		
		return ob;
		
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("AFterTest");
	}
	
	

}
