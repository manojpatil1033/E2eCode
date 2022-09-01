package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/data.properties");
		prop.load(fis);
		
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.out.println(prop.getProperty("browser"));
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\E2EProject\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			//Firefox Code
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			//FireFox Code
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public String getScreenshot(String methodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File("./reports/"+methodName+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String destPath="./reports/FailedScreenShots/"+methodName+".png";
		FileUtils.copyFile(src, new File(destPath));
		return destPath;
		
	}

	
	
	

}
