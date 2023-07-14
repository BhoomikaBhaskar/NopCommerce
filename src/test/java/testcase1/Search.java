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
		 
		 
	 driver.findElement(By.id(LocatorsPage.SearchBox)).sendKeys("laptop");
	 driver.findElement(By.xpath(LocatorsPage.SearchClick)).click();
	 
	 Assert.assertTrue(driver.findElement(By.linkText(LocatorsPage.AsusLaptop)).isDisplayed());
	 Assert.assertTrue(driver.findElement(By.linkText(LocatorsPage.LenovoLaptop)).isDisplayed(),"Valid product is not displayed");
	 
		
	}
	@Test(priority=2)
	public void VerifySearchWithInvalidProduct(){
	
		driver.findElement(By.id(LocatorsPage.SearchBox)).sendKeys("Amazon");
		driver.findElement(By.xpath(LocatorsPage.SearchClick)).click();
		String ActualText = driver.findElement(By.xpath(LocatorsPage.NoResultOnInvalidSearch)).getText();
		
		Assert.assertEquals(ActualText,"No products were found that matched your criteria."," message not displayed");
		
	
	}
	
	
	@Test(priority=3)
	
	public void VerifySearchWIthoutProductName() {
	
		driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
		
		
	}
	
	
}
