package datadrivenpractice.OrangeHRM.BasicFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class GenericMethods {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public GenericMethods()
	{
		try 
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Practice\\DatadrivenFramework\\src\\main\\resources\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void OpenBrowser()
	{
		String BrowserType = prop.getProperty("browser");
		
		if(BrowserType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserType.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

	

}
