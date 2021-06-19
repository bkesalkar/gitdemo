package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver driver;
 By Email  = By.xpath("//div[@class='form-fields']/div/input[@name='Email']");
 By Password= By.xpath("//div[@class='inputs']/input[@name='Password']");
 By LoginBtn = By.xpath("//div[@class='buttons']/button[@type='submit']");
 
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
 }
public WebElement getEmail()
{
	return driver.findElement(Email);
	
}
public WebElement getPassword()
{
	return driver.findElement(Password);
	
}
public WebElement getLoginBtn()
{
	return driver.findElement(LoginBtn);
	
}

}
