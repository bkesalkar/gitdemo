package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
public WebDriver driver;
 By login  = By.xpath("//li/a[.='Log in']");
 By title = By.xpath("//div[@class='page-title']/h1[.='Welcome, Please Sign In!']");
 
 public LandingPage(WebDriver driver)
 {
	 this.driver=driver;
 }
public WebElement getlogin()
{
	return driver.findElement(login);
	
}
public WebElement getTitle()
{
	return driver.findElement(title);
	
}
}
