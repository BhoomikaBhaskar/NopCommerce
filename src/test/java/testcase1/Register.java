package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Testcasebase.Base;

public class Register extends Base{
	WebDriver driver;

	

	@BeforeMethod
	public void setup() {
		
		loadPropertiesfile();
		driver = InitialseBrowserandopenApp(Prop.getProperty("browser"));
		driver.get(Prop.getProperty("uRL"));
		driver.findElement(By.linkText("Register")).click();
		
	}
	


	
	@Test(priority=1)
	public void RegisterWithValidCred()  {
		
		
		
		driver.findElement(By.id("FirstName")).sendKeys("Bhoomika");
		driver.findElement(By.id("LastName")).sendKeys("Bhaskar");
		Select drpDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
		drpDate.selectByVisibleText("11");
		Select drpMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		drpMonth.selectByVisibleText("January");
		Select drpYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
		drpYear.selectByVisibleText("2001");
		driver.findElement(By.name("Email")).sendKeys(Generate_email_with_timestamp());
		driver.findElement(By.name("Company")).sendKeys("123Creations");
		driver.findElement(By.name("Password")).sendKeys("123456789");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456789");
		driver.findElement(By.name("register-button")).click();
		
		
		
//		Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"Your registration completed\"]")).isDisplayed());
		
		String successfullycreated = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
		Assert.assertEquals(successfullycreated,"Your registration completed");
		
		
	}	
		
	
	
	public void VerifyRegisteringWithExistingEmail() {
			
			
			driver.findElement(By.xpath("//*[text()=\"Female\"]")).click();
			driver.findElement(By.id("FirstName")).sendKeys("Bhoomika");
			driver.findElement(By.id("LastName")).sendKeys("Bhaskar");
			Select drpDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
			drpDate.selectByVisibleText("11");
			Select drpMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
			drpMonth.selectByVisibleText("January");
			Select drpYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
			drpYear.selectByVisibleText("2001");
			driver.findElement(By.name("Email")).sendKeys("bhoomi@gmail.com");
			driver.findElement(By.name("Company")).sendKeys("123Creations");
			driver.findElement(By.name("Password")).sendKeys("123456789");
			driver.findElement(By.name("ConfirmPassword")).sendKeys("123456789");
			driver.findElement(By.name("register-button")).click();
			String accountexist = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li")).getText();
			Assert.assertTrue(accountexist.contains("The specified email already exists"),"warnning not displayed");
     	
			
			
		}
	
	@Test
	public void VerifyRegisteringAccountWithoutProvidingAnyDetails() {
		
		driver.findElement(By.name("register-button")).click();
		
		String ActualFirstNameWarning = driver.findElement(By.id("FirstName-error")).getText();
		Assert.assertEquals(ActualFirstNameWarning,"First name is required.","First name warning failed");
		
		String ActualLastNameWarning = driver.findElement(By.id("LastName-error")).getText();
		Assert.assertEquals(ActualLastNameWarning,"Last name is required.","Last name warning failed");
		
		String EmailWarning = driver.findElement(By.id("Email-error")).getText();
		Assert.assertEquals(EmailWarning,"Email is required.","Email warning failed");

		String PasswordWarning = driver.findElement(By.id("Password-error")).getText();
		Assert.assertEquals(PasswordWarning,"Password is required.","Pasword warning failed");
		
		String ConfirmPassword = driver.findElement(By.id("ConfirmPassword-error")).getText();
		Assert.assertEquals(ConfirmPassword,"Password is required.","Confirm passowrd warning failed");
		
		
		
		
	}
		

}
