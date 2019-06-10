package com.amazon.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.InputDataPojo.ValidLogin;
import com.amazon.common.CommonUtils;
import com.amazon.dataprovider.CredentialsDataProvider;
import com.amazon.pageActions.LoginAction;
import com.amazon.pageobjects.LoginPage;

public class LoginTest {
	CommonUtils commonutils;

	public LoginTest() {

		commonutils = new CommonUtils();

	}
//	@BeforeClass
//	public void beforeClass() {
//		WebDriver driver = new ChromeDriver();
//	}
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 1)
	public void sanity_loginWithValidEmail(ValidLogin validLoginData) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		LoginAction loginAction = new LoginAction(driver);
		System.out.println("Executing input: " + validLoginData.getEmail());
		loginAction.loginWithEmail(validLoginData.getEmail(), validLoginData.getPassword());
		driver.quit();
	}
	
//	@AfterClass
//	public void afterClass()
//	{
//		
//	}
}
