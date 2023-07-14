package testcase1;

public class LocatorsPage {
	
	//Registration 1 with RegisterWithValidCred
	static String FirstName = "FirstName";
	static String LastName = "LastName";
	static String DateOfBirthDay = "DateOfBirthDay";
	static String DateOfBirthMonth = "DateOfBirthMonth";
	static String DateOfBirthYear = "DateOfBirthYear";
	static String NewEmail = "Email";
	static String Company = "Company";
	static String Password = "Password";
	static String ConfirmPassword = "ConfirmPassword";
	static String RegisterButton = "register-button";
	static String RegistrationSuccessfullyCompleted = "\"//div[@class=\\\"result\\\"]\"";
	
	
	//Registration 2 with VerifyRegisteringWithExistingEmail
	static String ExistingEmailCheck = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li";
	
	//Registration 3 with VerifyRegisteringAccountWithoutProvidingAnyDetails
	static String EmptyFieldFirstName = "FirstName-error";
	static String EmptyFieldLastName = "LastName-error";
	static String EmptyFieldEmail = "Email-error";
	static String EmptyFieldPassword = "Password-error";
	static String EmptyFieldConfirmPassword = "ConfirmPassword-error";
	
    //Login 1 with Loginwithvalidcredentials
	static String Login = "//*[@class = 'button-1 login-button']";
	
	//Login 2 with Loginwithonlyinvalidcredentials
	static String UnSuccessfulLoginMessage = "//div[@class='message-error validation-summary-errors']";
	
	//Search product 1 verifySearchWithValidProduct
	static String SearchBox = "small-searchterms";
	static String SearchClick = "//*[@id=\"small-search-box-form\"]/button";
	static String AsusLaptop = "Asus N551JK-XO076H Laptop";
	static String LenovoLaptop = "Lenovo Thinkpad X1 Carbon Laptop";
	
	//Search product 2  VerifySearchWithInvalidProduct
	static String NoResultOnInvalidSearch = "//div[@class='no-result']";
	
	
	
	
}
