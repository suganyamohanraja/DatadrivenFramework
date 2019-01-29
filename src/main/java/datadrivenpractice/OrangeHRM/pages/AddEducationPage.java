package datadrivenpractice.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import datadrivenpractice.OrangeHRM.BasicFunctions.GenericMethods;

public class AddEducationPage extends GenericMethods {
private static WebElement element = null;
	
	public static WebElement AddEducation(WebDriver driver)
	 {
		   element = driver.findElement(By.id("btnAdd"));
		 
		    return element;
		 
	 }
	
	public static WebElement AddEducationlevel(WebDriver driver)
	 {
		   element = driver.findElement(By.id("education_name"));
		 
		    return element;
		 
	 }

	public static WebElement SaveEducationlevel(WebDriver driver)
	 {
		   element = driver.findElement(By.id("btnSave"));
		 
		    return element;
		 
	 }
	public void NavigateAddEducation()
	{
		AddEducation(driver).click();
	}
	
	public void Entereducationlevel(String levelname)
	{
		AddEducationlevel(driver).sendKeys(levelname);
		SaveEducationlevel(driver).click();
	}
}
