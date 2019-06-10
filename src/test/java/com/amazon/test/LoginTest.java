package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.InputDataPojo.ValidLogin;
import com.amazon.common.CommonUtils;
import com.amazon.dataprovider.CredentialsDataProvider;
import com.amazon.pageobjects.LoginPage;

public class LoginTest {
	CommonUtils commonutils;

	public LoginTest() {

		commonutils = new CommonUtils();

	}

	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 1)
	public void sanity_loginWithValidEmail(ValidLogin validLoginData) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");

		LoginPage loginPage = new LoginPage(driver);
		System.out.println("Executing input: " + validLoginData.getEmail());
		loginPage.loginWithValidEmail(validLoginData.getEmail(), validLoginData.getPassword());

		driver.quit();
	}

//	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 2)
//	public void sanity_addHeadPhoneToCart() {
//		
//		
//	}
}
