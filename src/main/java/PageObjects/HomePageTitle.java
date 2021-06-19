package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTitle {
	public WebDriver driver;
	By hometitle = By.xpath("//div[@class='topic-block-title']/h2");
	
	public HomePageTitle(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getHomePageTitle()
	{
		return driver.findElement(hometitle);
		
	}
}
