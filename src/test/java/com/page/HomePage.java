package com.page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.TestBase;

import PageObjects.AddToCartItems;
import PageObjects.HomePageTitle;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

public class HomePage extends TestBase {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializationBrowser();
		driver.get(prop.getProperty("URL"));
	}
	
	@Test(dataProvider="getData")
	public void BasePageNavigation(String Username,String Password) throws IOException, InterruptedException
	{
		LandingPage L = new LandingPage(driver);
		String title= L.getTitle().getText();
		Assert.assertEquals(title,"Welcome, Please Sign In!");
		//L.getlogin().click();
		LoginPage LP = new LoginPage(driver);
		LP.getEmail().sendKeys(Username);
		LP.getPassword().sendKeys(Password);
		LP.getLoginBtn().click();
		Thread.sleep(2000);
		HomePageTitle H = new HomePageTitle(driver);
		String Hometitile=H.getHomePageTitle().getText();
		Assert.assertEquals(Hometitile, "Welcome to our store");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		//0th row 
		data[0][0]="kesalkarbhairavi@gmail.com";
		data[0][1]="Bhairavi@20";
		
		data[1][0]="kesalkarbhairavi";
		data[1][1]="Bhairavi@20";
		return data;
	}
	
}
