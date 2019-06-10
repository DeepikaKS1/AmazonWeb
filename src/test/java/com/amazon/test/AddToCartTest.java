package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.amazon.pageActions.AddToCartAction;

public class AddToCartTest {
	@Test(priority = 1)
	public void sanity_addToCartHeadPhone() {
	
	WebDriver driver = new ChromeDriver();
	AddToCartAction addToCartHeadPhone = new AddToCartAction(driver);
	addToCartHeadPhone.addHeadphonesToCart();
	}
}
