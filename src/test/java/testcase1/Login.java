package testcase1;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Testcasebase.Base;

public class Login extends Base{
	
	public Login() {
		super();
	}

	@BeforeMethod
	public void setup() {
		
	
		
		driver = InitialseBrowserandopenApp(Prop.getProperty("browser"));
		driver.get(Prop.getProperty("uRL"));
		driver.findElement(By.linkText("Log in")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=2)
	public void Loginwithvalidcredentials() {
		
		driver.findElement(By.id(LocatorsPage.NewEmail)).sendKeys(Email.getProperty("newUserEmailAddress"));
		driver.findElement(By.id(LocatorsPage.Password)).sendKeys("123456789");
		driver.findElement(By.xpath(LocatorsPage.Login)).click();
		
		
	}
	@Test(priority=1)
	public void Loginwithonlyinvalidcredentials() {
	
		driver.findElement(By.id(LocatorsPage.NewEmail)).sendKeys("111@mailinator.com");
		driver.findElement(By.name(LocatorsPage.Password)).sendKeys("123456");
		driver.findElement(By.xpath(LocatorsPage.Login)).click();
		String invalid = driver.findElement(By.xpath(LocatorsPage.UnSuccessfulLoginMessage)).getText();
		
		Assert.assertEquals(invalid,"Login was unsuccessful. Please correct the errors and try again.\r\n"
				+ "No customer account found","passed successfully with invalid credentials");
		
		
	}
	
	
	
	
	

}
