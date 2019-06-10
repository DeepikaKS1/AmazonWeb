package com.amazon.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pageobjects.HomePage;

public class AddToCartAction {
	WebDriver driver;
	
	public AddToCartAction(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void addToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.getAddToCartBtn.click();
	}
	
	public void addHeadphonesToCart() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		HomePage homepage=new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(homepage.getDepartmentLink).perform();
		homepage.getElectronics.click();
		homepage.getHeadphones.click();
		wait.until(ExpectedConditions.visibilityOf(homepage.getFirstHeadphones));
		homepage.getFirstHeadphones.click();
		addToCart();
	}

}
