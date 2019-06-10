package com.amazon.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.common.CommonUtils;
import com.amazon.pageobjects.LoginPage;

public class LoginAction {
	WebDriver driver;
	
	public LoginAction(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void loginWithEmail(String email, String password) {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		CommonUtils.waitFor(5000);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getSignInLink.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ap_email"))));
		CommonUtils.waitFor(4000);
		loginPage.emailField.sendKeys(email);
		loginPage.passwordField.sendKeys(password);
		loginPage.signInButton.click();
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]"));
		wait.until(ExpectedConditions.visibilityOf(userName));
		if(userName.isDisplayed()) {
			System.out.println(userName.getText().replace("Hello, ", ""));
			System.out.println("Login is successful");
		}
		else {
			System.out.println("Login is unsuccessful");
		}
	}
}
