package com.page;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.util.TestBase;

import PageObjects.AddToCartItems;
import PageObjects.HomePageTitle;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import test.configuration.Base;

public class ValidateAddtocartitems extends TestBase {
	//String username= "kesalkarbhairavi@gmail.com";
	//String password= "Bhairavi@20";
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(ValidateAddtocartitems.class);
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializationBrowser();
		Log.info("diver is initialized");
		driver.get(prop.getProperty("URL"));
		Log.info("Navigate to home page");
	}
	@Test
	public void Checkout() throws InterruptedException
	{
		AddToCartItems ac = new AddToCartItems(driver);
		ac.getJewelrybtn().click();
		String[] itemsneeded = {"Fahrenheit 451 by Ray Bradbury","First Prize Pies","Pride and Prejudice"};
		ac.addItems(driver,itemsneeded);
		Log.info("Successfully add item in cart");
		Log.error("Error.............");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
