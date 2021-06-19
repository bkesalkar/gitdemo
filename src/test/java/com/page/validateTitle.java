package com.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.util.TestBase;

import PageObjects.LandingPage;

public class validateTitle extends TestBase{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializationBrowser();
		driver.get(prop.getProperty("URL"));
	}
	
	@Test
	public void ValidationTitle()
	{
		LandingPage L = new LandingPage(driver);
		String title= L.getTitle().getText();
		Assert.assertEquals(title,"Welcome, Please Sign In!");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
