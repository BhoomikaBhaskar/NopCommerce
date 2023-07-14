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
	
	
	
	
	
	
	
	@BeforeMethod
	public void setup() {
		
	
		loadPropertiesfile();
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
		
		
	
		driver.findElement(By.id("Email")).sendKeys(Email.getProperty("newUserEmailAddress"));
		driver.findElement(By.id("Password")).sendKeys("123456789");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
		
		
	}
	@Test
	public void Loginwithonlyinvalidcredentials() {
	
		driver.findElement(By.id("Email")).sendKeys("111@mailinator.com");
		driver.findElement(By.name("Password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
		String invalid = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
		Assert.assertEquals(invalid,"Login was unsuccessful. Please correct the errors and try again.\r\n"
				+ "No customer account found","passed successfully with invalid credentials");
		
		
	}
	
	
	
	
	

}
