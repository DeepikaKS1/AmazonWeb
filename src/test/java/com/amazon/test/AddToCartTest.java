package com.amazon.test;

import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.InputDataPojo.ValidLogin;
import com.amazon.common.CommonUtils;
import com.amazon.dataprovider.CredentialsDataProvider;
import com.amazon.extentReports.ExtentTestManager;
import com.amazon.pageActions.AddToCartAction;
import com.amazon.pageActions.LoginAction;

import extentReports.ExtentReport;

public class AddToCartTest {
	
	CommonUtils commonutils;
	protected WebDriver driver;
	AddToCartAction addToCartAction;
	

	public AddToCartTest() {
		commonutils = new CommonUtils();
		 
	}
	
	@BeforeTest
	public void beforeClass(){
		
//		if(browser.equalsIgnoreCase("chrome")) {	
			driver = new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else 
//			throw new Exception("Browser is not correct");
		addToCartAction = new AddToCartAction(driver);
//		ExtentReport extent = new ExtentReport();
//		logger = extent.startTest("ExtentReports");
		
	}
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 1, enabled = true)
	public void loginWithValidEmail(ValidLogin validLoginData, Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Invalid Login.");
		ExtentTestManager.getTest();
		
		//WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		LoginAction loginAction= new LoginAction(driver);
		System.out.println("Executing input: " + validLoginData.getEmail());
		loginAction.loginWithEmail(validLoginData.getEmail(), validLoginData.getPassword());
	}
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 2, enabled = true)
	public void addToCartHeadPhone(ValidLogin validLoginData, Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Invalid Login.");
		ExtentTestManager.getTest();
		
		AddToCartAction addToCartHeadPhone = new AddToCartAction(driver);
		addToCartHeadPhone.addHeadphonesToCart();
		
	}
	
	@Test(dataProviderClass = CredentialsDataProvider.class, dataProvider = "ValidLogin", priority = 3, enabled = true)
	public void addToCartMacbook(ValidLogin validLoginData,Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Invalid Login.");
		ExtentTestManager.getTest();
		
		AddToCartAction addToCartMacBook = new AddToCartAction(driver);
		addToCartMacBook.addMacBookPro();
	}
	
	@Test(priority = 4, enabled = true)
	public void sanity_deleteHeadPhonesAndMacFromCart(Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Invalid Login.");
		ExtentTestManager.getTest();
		
		addToCartAction.navigateToHomePage();
		addToCartAction.sanity_deleteHeadPhonesFromCart();
		addToCartAction.sanity_reduceMacQuantityFromCart();
	}
	
	@AfterTest
	public void afterClass()
	{	
		LoginAction loginAction= new LoginAction(driver);
		//loginAction.logout();
		driver.quit();
	}
	
}
