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

	public Register() {
		super();
	}
	@BeforeMethod
	public void setup() {
		
		driver = InitialseBrowserandopenApp(Prop.getProperty("browser"));
		driver.get(Prop.getProperty("uRL"));
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@Test(priority=1)
	public void RegisterWithValidCred()  {
		
		driver.findElement(By.id(LocatorsPage.FirstName)).sendKeys("Bhoomika");
		driver.findElement(By.id(LocatorsPage.LastName)).sendKeys("Bhaskar");
		Select drpDate = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthDay)));
		drpDate.selectByVisibleText("11");
		Select drpMonth = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthMonth)));
		drpMonth.selectByVisibleText("January");
		Select drpYear = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthYear)));
		drpYear.selectByVisibleText("2001");
		driver.findElement(By.name(LocatorsPage.NewEmail)).sendKeys(Generate_email_with_timestamp());
		driver.findElement(By.name(LocatorsPage.Company)).sendKeys("123Creations");
		driver.findElement(By.name(LocatorsPage.Password)).sendKeys("123456789");
		driver.findElement(By.name(LocatorsPage.ConfirmPassword)).sendKeys("123456789");
		driver.findElement(By.name(LocatorsPage.RegisterButton)).click();
		
//		Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"Your registration completed\"]")).isDisplayed());
		
		String successfullycreated = driver.findElement(By.xpath(LocatorsPage.RegistrationSuccessfullyCompleted)).getText();
		Assert.assertEquals(successfullycreated,"Your registration completed");

	}	

	public void VerifyRegisteringWithExistingEmail() {
			
			
		driver.findElement(By.id(LocatorsPage.FirstName)).sendKeys("Bhoomika");
		driver.findElement(By.id(LocatorsPage.LastName)).sendKeys("Bhaskar");
		Select drpDate = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthDay)));
		drpDate.selectByVisibleText("11");
		Select drpMonth = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthMonth)));
		drpMonth.selectByVisibleText("January");
		Select drpYear = new Select(driver.findElement(By.name(LocatorsPage.DateOfBirthYear)));
		drpYear.selectByVisibleText("2001");
		driver.findElement(By.name(LocatorsPage.NewEmail)).sendKeys(Generate_email_with_timestamp());
		driver.findElement(By.name(LocatorsPage.Company)).sendKeys("123Creations");
		driver.findElement(By.name(LocatorsPage.Password)).sendKeys("123456789");
		driver.findElement(By.name(LocatorsPage.ConfirmPassword)).sendKeys("123456789");
		driver.findElement(By.name(LocatorsPage.RegisterButton)).click();
			
			
			String accountexist = driver.findElement(By.xpath(LocatorsPage.ExistingEmailCheck)).getText();
			Assert.assertTrue(accountexist.contains("The specified email already exists"),"warnning not displayed");
     		
		}
	
	@Test
	public void VerifyRegisteringAccountWithoutProvidingAnyDetails() {
		
		driver.findElement(By.name(LocatorsPage.RegisterButton)).click();
		
		String ActualFirstNameWarning = driver.findElement(By.id(LocatorsPage.EmptyFieldFirstName)).getText();
		Assert.assertEquals(ActualFirstNameWarning,"First name is required.","First name warning failed");
		
		String ActualLastNameWarning = driver.findElement(By.id(LocatorsPage.EmptyFieldLastName)).getText();
		Assert.assertEquals(ActualLastNameWarning,"Last name is required.","Last name warning failed");
		
		String EmailWarning = driver.findElement(By.id(LocatorsPage.EmptyFieldEmail)).getText();
		Assert.assertEquals(EmailWarning,"Email is required.","Email warning failed");

		String PasswordWarning = driver.findElement(By.id(LocatorsPage.EmptyFieldPassword)).getText();
		Assert.assertEquals(PasswordWarning,"Password is required.","Pasword warning failed");
		
		String ConfirmPassword = driver.findElement(By.id(LocatorsPage.EmptyFieldConfirmPassword)).getText();
		Assert.assertEquals(ConfirmPassword,"Password is required.","Confirm passowrd warning failed");
		
		
		
		
	}
		

}
