package PageObjects;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.TestUtil;

public class AddToCartItems {
	public WebDriver driver;
	By product= By.xpath("//h2[@class='product-title']");
	By addtocartbtn = By.xpath("//div[@class='buttons']/button[.='Add to cart']");
	By JewelryBtn = By.xpath("//ul[@class='top-menu notmobile']/li[5]/a[.='Books ']");
	
	public AddToCartItems(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getproductbtn()
	{
		return driver.findElement(product);
	}
	public WebElement getAddtocartbtn()

	{
		return driver.findElement(addtocartbtn);
	}
	public WebElement getJewelrybtn()
	{
		return driver.findElement(JewelryBtn);
	}
	public void addItems(WebDriver driver,String[] itemsneeded) throws InterruptedException
	{
		int j=0;
		 List<WebElement> products = driver.findElements(product);
		 System.out.println(products.size());
		 for(int i=0;i<products.size();i++)
		 {
		 String name = products.get(i).getText(); //gettext method get "Brocolli - 1 Kg" text but we write brocoli in array so thet we have to split this name 
		// String formatedname = name[0].trim(); //trim used for remove wide space
		 List itemsneededlist = Arrays.asList(itemsneeded); //array convert into array list
		 System.out.println("List"+itemsneededlist);
		 if(itemsneededlist.contains(name))
			{
			 System.out.println(name);
	    	 j++;
	    	 //click on add to cart
				//driver.findElement(By.xpath("//h4[.='Cucumber - 1 Kg']/following-sibling::div/button")).click();
	    	 driver.findElements(addtocartbtn).get(i).click();
	    	 //driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
	    	 //WebDriverWait wait = new WebDriverWait(driver,30);
	    	 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='content']/a[.='shopping cart']")));
	    	 Thread.sleep(2000);
				System.out.println(j);
			}
	     if(j==itemsneeded.length)
	     {
	    	 break;
	     }
		 }
		 
	}

}
