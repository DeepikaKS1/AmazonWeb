package com.amazon.pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazon.common.CommonUtils;
import com.amazon.pageobjects.HomePage;

public class AddToCartAction {
	WebDriver driver;
	HomePage homepage;
	Actions action;
	WebDriverWait wait;
	CommonUtils commonUtils;
	
	public AddToCartAction(WebDriver driver) {
		//PageFactory.initElements(driver, this);
		this.driver = driver;
		homepage=new HomePage(driver);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		commonUtils = new CommonUtils();
	}
	
	public void addToCart() {
		HomePage homePage = new HomePage(driver);
		homePage.getAddToCartBtn.click();
	}
	
	public void addHeadphonesToCart() {
		
		action.moveToElement(homepage.getDepartmentLink).perform();
		homepage.getElectronics.click();
		//wait.until(ExpectedConditions.elementToBeClickable(homepage.getHeadphones));
		homepage.getHeadphones.click();
		wait.until(ExpectedConditions.visibilityOf(homepage.getFirstHeadphones));
		homepage.getFirstHeadphones.click();
		addToCart();
		wait.until(ExpectedConditions.visibilityOf(homepage.getAddedToCart));
		Assert.assertEquals("Added to Cart", homepage.getAddedToCart.getText());
		homepage.getCloseBtn.click();
	}
	
	public void addMacBookPro() {
		
		commonUtils.waitFor(3000);
		homepage.getSearchBox.sendKeys("Macbook pro");
		
		homepage.getSearchEnter.click();
		
		wait.until(ExpectedConditions.visibilityOf(homepage.getMacbookpro));
		homepage.getMacbookpro.click();
		System.out.println("Selected 2nd macbook pro");
		
		wait.until(ExpectedConditions.visibilityOf(homepage.getQuantity));
		homepage.getQuantity.sendKeys("2");
		
		addToCart();
		
		wait.until(ExpectedConditions.visibilityOf(homepage.getMacAddedToCart));
		Assert.assertEquals("Added to Cart", homepage.getMacAddedToCart.getText());
	}

	public void navigateToHomePage() {
		homepage.home.click();
	}
	
	public void sanity_deleteHeadPhonesFromCart() {
		wait.until(ExpectedConditions.visibilityOf(homepage.cartHome));
		homepage.cartHome.click();
		List<WebElement> cartItems = homepage.getAllCartItems();

		System.out.println(cartItems.size());
		cartItems.forEach(item -> {
			String itemName = item.findElement(By.xpath("./div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span"))
					.getText();
			if (itemName.toLowerCase().contains("headphones")) {
				commonUtils.waitFor(10);
				System.out.println("Action on headphones");
				WebElement deleteBtn = item
						.findElement(By.xpath("./div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input"));
				wait.until(ExpectedConditions.visibilityOf(deleteBtn));
				deleteBtn.click();
			}
		});
	}
	
	public void sanity_reduceMacQuantityFromCart() {
		wait.until(ExpectedConditions.visibilityOf(homepage.cartHome));
		homepage.cartHome.click();
		List<WebElement> cartItems = homepage.getAllCartItems();
		System.out.println(cartItems.size());

		cartItems.forEach(item -> {
			String itemName = item.findElement(By.xpath("./div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span"))
					.getText();
			if (itemName.toLowerCase().contains("macbook")) {
				System.out.println("Action on macbook");
				WebElement removeMac = driver.findElement(By.id("a-autoid-0-announce"));
				removeMac.click();
				WebElement select1 = driver.findElement(By.id("dropdown1_0"));
				select1.click();
				commonUtils.waitFor(10);
			}
		});
	}
	
	
}
