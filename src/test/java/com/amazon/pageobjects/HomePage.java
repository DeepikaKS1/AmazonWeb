package com.amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
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
	
//	@FindBy(id="Departments")
//	public WebElement getDepartmentLink;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/a[11]/span")
	public WebElement getElectronics;
	
//	@FindBy(xpath="//*[@class=‘nav-text’]//*[text()=‘Electronics’]")
//	public WebElement getElectronics;
	
	@FindBy(xpath="//*[@id=\"merchandised-content\"]/div[4]/div/div[1]/div/a")
	public WebElement getHeadphones;
	
//	@FindBy(xpath="//span[text()=‘HEADPHONES’]")
//	public WebElement getHeadphones;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
	public WebElement getFirstHeadphones;
	
	@FindBy(id="add-to-cart-button")
	public WebElement getAddToCartBtn;
	
	@FindBy(id="attachDisplayAddBaseAlert")
	public WebElement getAddedToCart;
	
	@FindBy(id="huc-v2-order-row-confirm-text")
	public WebElement getMacAddedToCart;
	
	@FindBy(id="attach-close_sideSheet-link")
	public WebElement getCloseBtn;
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement getSearchBox;
	
	@FindBy(xpath="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	public WebElement getSearchEnter;
	
	@FindBy(id="pdagDesktopSparkleDescription2")
	public WebElement getMacbookpro;
	
	@FindBy(id="quantity")
	public WebElement getQuantity;
	
	@FindBy(id="hlb-view-cart-announce")
	public WebElement getCartHome;
	
	@FindBy(id="nav-cart")
	public WebElement cartHome;
	
	@FindBy(id="nav-logo")
	public WebElement home;
	
	public List<WebElement> getAllCartItems() {
		//*[@id="activeCartViewForm"]/div[2]
		WebElement cart = driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]"));
		//List<WebElement> cartItems = cart.findElements(By.tagName("div"));
		List<WebElement> cartItems = cart.findElements(By.xpath("./div"));
		
		return cartItems;
	}
}
