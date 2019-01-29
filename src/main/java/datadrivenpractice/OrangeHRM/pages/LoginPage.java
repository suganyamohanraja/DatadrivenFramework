package datadrivenpractice.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import datadrivenpractice.OrangeHRM.BasicFunctions.GenericMethods;
import datadrivenpractice.OrangeHRM.utilities.Log;





public class LoginPage extends GenericMethods {

	private static WebElement element = null;
	
	 public static WebElement userName(WebDriver driver)
	 {
		   element = driver.findElement(By.name("txtUsername"));
		   Log.info("Username field found");
		 
		    return element;
		 
	 }
	 
	 public static WebElement Password(WebDriver driver)
	 {
		   element = driver.findElement(By.name("txtPassword"));
		 
		    return element;
		 
	 }
	 
	 public static WebElement Login(WebDriver driver)
	 {
		   element = driver.findElement(By.id("btnLogin"));
		 
		    return element;
		 
	 }
	 public static WebElement Logo(WebDriver driver)
	 {
		   element = driver.findElement(By.xpath("//*[@id='divLogo']//img"));
		 
		    return element;
		 
	 }
	 
	 public String ValidateLoginTitle()
		{
			return driver.getTitle();
		}
		
		public boolean ValidateLogo()
		{
			return Logo(driver).isDisplayed();
		}
		
		public void LoginFlow(String un,String pwd)
		{
			userName(driver).sendKeys(un);
			Password(driver).sendKeys(pwd);
			Login(driver).click();
			
			
		}
		
		public AddEducationPage SelectEducation()
		{
			WebElement element = driver.findElement(By.linkText("Admin"));
			 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	        WebElement element1 = driver.findElement(By.linkText("Qualifications"));
	        action.moveToElement(element1).build().perform();	 
	        driver.findElement(By.linkText("Education")).click();
	        return new AddEducationPage();
		}

		
}
