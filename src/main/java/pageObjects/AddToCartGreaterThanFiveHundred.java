package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class AddToCartGreaterThanFiveHundred extends Base {

	public WebDriver driver;

	@FindBy(css = "button.btn.btn-solid.add-to-cart-btn")
	private WebElement AddToCartButton;

	@FindBy(xpath = "(//img[@class='img-fluid bg-img img-lazy-loading-effect']) [1]")
	private WebElement ClickOnFirstProduct;

	public AddToCartGreaterThanFiveHundred(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement addToCart() {
		Set<String> windowid = driver.getWindowHandles();
		Iterator<String> windowIndex = windowid.iterator();
		String parentId = windowIndex.next();
		String childID = windowIndex.next();

		driver.switchTo().window(childID);

		return AddToCartButton;
	}

	public WebElement clickFirstProduct() {

		return ClickOnFirstProduct;
	}

}
