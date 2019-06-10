package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.InputDataPojo.ValidLogin;
import com.amazon.dataprovider.CredentialsDataProvider;
import com.amazon.pageActions.AddToCartAction;
import com.amazon.pageActions.LoginAction;

public class AddToCartTest {
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 1)
	public void sanity_addToCartHeadPhone(ValidLogin validLoginData) {
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.amazon.com");
	driver.manage().window().maximize();
	LoginAction loginAction = new LoginAction(driver);
	System.out.println("Executing input: " + validLoginData.getEmail());
	loginAction.loginWithEmail(validLoginData.getEmail(), validLoginData.getPassword());
	AddToCartAction addToCartHeadPhone = new AddToCartAction(driver);
	addToCartHeadPhone.addHeadphonesToCart();
	driver.quit();
	}
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 2)
	public void sanity_addToCartMacbook(ValidLogin validLoginData) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		LoginAction loginAction = new LoginAction(driver);
		System.out.println("Executing input: " + validLoginData.getEmail());
		loginAction.loginWithEmail(validLoginData.getEmail(), validLoginData.getPassword());
	}
}
