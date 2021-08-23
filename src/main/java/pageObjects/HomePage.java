package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePage extends Base {

	public WebDriver driver;

	@FindBy(css = "li.onhover-dropdown")
	private WebElement profilebutton;

	@FindBy(linkText = "Login")
	private WebElement loginbutton;
	
	@FindBy(css = "span.forgot")
	private WebElement Forgot;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement getProfileButton() {

		return profilebutton;
	}

	public WebElement getLoginButton() {
		return loginbutton;
	}
	
	public boolean getForgot() {
		return Forgot.isDisplayed();
	}


}
