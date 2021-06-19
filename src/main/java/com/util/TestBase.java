package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public static Logger Log = LogManager.getLogger(TestBase.class);
	
	public WebDriver initializationBrowser() throws IOException
	{
		prop = new Properties();
		//C:\\Users\\Lenovo\\eclipse-workspace\\DemoH1Cycle\\src\\main\\java\\com\\config\\config.properties
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
		prop.load(fis);
		
		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);
		System.out.println(prop.getProperty("URL"));
		String path = System.getProperty("user.dir");
		System.out.println(path);
		//C:\\Users\\Lenovo\\eclipse-workspace\\DemoH1Cycle\\src\\main\\java\\Resource\\chromedriver.exe
		if (BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (BrowserName.equals("FireFox"))
		{
			//System.setProperty("webdriver.gecko.driver","D:\\chromedriver.exe");
			 //driver = new FirefoxDriver();
	    }
		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\eclipse-workspace\\DemoH1Cycle\\src\\test\\java\\Resources\\chromedriver.exe");
		 driver = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public String getScreenshotPath(String Testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
