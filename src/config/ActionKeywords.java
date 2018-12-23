package config;

import static exectionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActionKeywords {
	public static WebDriver driver;
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "G:\\cigniti\\cigniti\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void navigate()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
	}
	
	public static void click(String object) 
	{
		 driver.findElement(By.xpath(OR.getProperty(object))).click();
		
	}
	
	public static void input_Username()
	{
        driver.findElement(By.id("log")).sendKeys(Constants.UserName); 
	}
	
	public static void input_Password()
	{
		driver.findElement(By.id("pwd")).sendKeys(Constants.Password);
		
	}
	
	public static void click_Login()
	{
		
		driver.findElement(By.id("login")).click();
	}
	
	public static void waitFor() throws Exception
	{
		Thread.sleep(1000);
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}

}
