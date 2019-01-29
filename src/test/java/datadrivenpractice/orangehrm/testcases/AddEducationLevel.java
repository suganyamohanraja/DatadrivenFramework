package datadrivenpractice.orangehrm.testcases;


import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import datadrivenpractice.OrangeHRM.BasicFunctions.GenericMethods;
import datadrivenpractice.OrangeHRM.pages.AddEducationPage;
import datadrivenpractice.OrangeHRM.pages.LoginPage;
import datadrivenpractice.OrangeHRM.utilities.ExcelReader;
import datadrivenpractice.OrangeHRM.utilities.Log;

public class AddEducationLevel extends GenericMethods {

	LoginPage loginPage;
	AddEducationPage Education;
	ExcelReader readdata = new ExcelReader();
	String EducationLevels = "Sheet1";
	
	public AddEducationLevel()
	{
		super();
	}
	@BeforeTest
	public void setup()
	{
		 DOMConfigurator.configure("log4j.xml");
		 
		 Log.startTestCase("Selenium_Test_001");		 
		 
		OpenBrowser();
		loginPage = new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.ValidateLoginTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test (priority=2)
	public void loginflowTest()
	{
		loginPage.LoginFlow(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=3)
	public void NavigateToEducationPage()
	{
		Education = loginPage.SelectEducation();
		
	}
	
	
	
	@DataProvider
	public Object[][] EducationLevelsData()

	{
		Object data[][]=ExcelReader.getTestData(EducationLevels);
		return data;
	}
	@Test(priority=4, dataProvider="EducationLevelsData")
	public void AddEducationDetails(String level)
	{
		Education.NavigateAddEducation();
		Education.Entereducationlevel(level);
		
	}
	@AfterTest()
	public void closeLogs()
	{

		 Log.endTestCase("Selenium_Test_001");
	}
}
