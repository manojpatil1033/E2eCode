package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	private WebDriver driver;
	By signIn=By.xpath("//a/span[text()='Login']");
	By getTitle= By.xpath("//div[@class='text-center']/h2");
	By navBar=By.cssSelector("ul.nav.navbar-nav.navbar-right li a");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public  WebElement getLoginDirectButton()
	{
		return driver.findElement(signIn);
		
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(getTitle);
	}
	
	public  WebElement navBarOption()
	{
		return driver.findElement(navBar);
		
	}
	
	

}
