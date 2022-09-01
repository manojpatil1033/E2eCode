package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	By username=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By login=By.xpath("//input[@type='submit']");
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getUserName()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(login);
	}
	

}
