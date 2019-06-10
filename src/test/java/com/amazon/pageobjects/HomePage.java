package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.common.CommonUtils;

public class HomePage {
	CommonUtils commonutils = new CommonUtils();
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id=\"nav-link-shopall\"]/span[2]")
	public WebElement getDepartmentLink;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/a[11]/span")
	public WebElement getElectronics;
	
	@FindBy(xpath="//*[@id=\"categoryTilesSoftlines_21326\"]/div/div[1]/div/a/div/span")
	public WebElement getHeadphones;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
	public WebElement getFirstHeadphones;
	
	@FindBy(id="add-to-cart-button")
	public WebElement getAddToCartBtn;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement getSearchBox;
	
	@FindBy(xpath="/html/body/div[2]/header/div/div[1]/div[3]/div/form/div[2]/div/input")
	public WebElement getSearchEnter;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[3]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
	public WebElement getMacbookpro;
	
	@FindBy(id="quantity")
	public WebElement getQuantity;
	
	@FindBy(id="hlb-view-cart-announce")
	public WebElement getCartHome;
}
