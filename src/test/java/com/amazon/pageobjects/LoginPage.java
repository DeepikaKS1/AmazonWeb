package com.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.common.CommonUtils;

import junit.framework.Assert;


public class LoginPage {
	CommonUtils commonutils = new CommonUtils();
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="nav-link-accountList")
	public WebElement getSignInLink;
	
	@FindBy(id="driver.findElement(By.id(\"ap_email\")")
	public WebElement getEmailField;
	
	@FindBy(id="ap_email")
	public WebElement emailField;
	
	@FindBy(id="ap_password")
	public WebElement passwordField;
	
	@FindBy(id="signInSubmit")
	public WebElement signInButton;
	
//	public void clickOnSignInBtn() {
//		this.getSignInLink.click();
//	}
//	
//	public boolean isSignInBtnDisplayed() {
//		return this.getSignInLink.isDisplayed();
//	}
	
	

}
