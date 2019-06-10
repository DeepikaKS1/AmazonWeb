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
	
	public void loginWithValidEmail(String email, String password) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		CommonUtils.waitFor(3000);
		//LoginPage loginPage=new LoginPage();
		this.getSignInLink.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ap_email"))));
		CommonUtils.waitFor(4000);
		WebElement emailField = driver.findElement(By.id("ap_email"));
		emailField.sendKeys(email);
		WebElement passwordField = driver.findElement(By.id("ap_password"));
		passwordField.sendKeys(password);
		WebElement signInButton = driver.findElement(By.id("signInSubmit"));
		signInButton.click();
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]"));
		wait.until(ExpectedConditions.visibilityOf(userName));
		if(userName.isDisplayed()) {
			System.out.println("Login is successful");
		}
		else {
			System.out.println("Login is unsuccessful");
		}
		
	}
	
	public void addToCart() {
		
	}

}
