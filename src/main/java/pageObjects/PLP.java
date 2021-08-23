package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class PLP extends Base {

	public WebDriver driver;

	@FindBy(xpath = "(//ul[@class='nav-sub-childmenu']) //li [1]")
	private WebElement ChildCat;

	@FindBy(xpath = "(//img[@class='img-fluid sub-image img-lazy-loading-effect img-lazy-loading-effect']) [1]")
	private WebElement MainCat;
	
	@FindBy(css = "li.dropdown")
	private WebElement AllCat;
	
	public PLP(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAllCategories() {

		return AllCat;
	}
	

	public WebElement getParentCategory() {

		return MainCat;
	}

	public WebElement getChildCategory() {
		return ChildCat;
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
}
