package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Testcasebase.Base;

public class Search extends Base {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = InitialseBrowserandopenApp("Chrome");
		driver.get("https://demo.nopcommerce.com/");
	}
	@AfterMethod
	public void teatdown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		 
		 
	 driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
	 driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
	 
	 Assert.assertTrue(driver.findElement(By.linkText("Asus N551JK-XO076H Laptop")).isDisplayed());
	 Assert.assertTrue(driver.findElement(By.linkText("Lenovo Thinkpad X1 Carbon Laptop")).isDisplayed(),"Valid product is not displayed");
	 
		
	}
	@Test(priority=2)
	public void VerifySearchWithInvalidProduct(){
	
		driver.findElement(By.id("small-searchterms")).sendKeys("Amazon");
		driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
		String ActualText = driver.findElement(By.xpath("//div[@class='no-result']")).getText();
		
		Assert.assertEquals(ActualText,"No products were found that matched your criteria."," message not displayed");
		
	
	}
	
	
	@Test(priority=3)
	
	public void VerifySearchWIthoutProductName() {
	
		driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
		
		
	}
	
	
}
