package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsLetterBox {
	
	private WebDriver driver;
	By crossButton=By.xpath("//div[@class='sumome-react-svg-image-container']");
	
	public NewsLetterBox(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public  WebElement getCrossButton()
	{
		return driver.findElement(crossButton);
		
	}

}
