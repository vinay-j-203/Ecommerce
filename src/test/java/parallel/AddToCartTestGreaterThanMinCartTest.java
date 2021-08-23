package parallel;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.AddToCartGreaterThanFiveHundred;
import resources.Base;

public class AddToCartTestGreaterThanMinCartTest extends Base {
	private static Logger log = (Logger) LogManager.getLogger(AddToCartTestGreaterThanMinCartTest.class.getName());
	AddToCartGreaterThanFiveHundred addCart = new AddToCartGreaterThanFiveHundred(driver);

	@Then("^click on the first product$")
	public void click_on_the_first_product() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addCart.clickFirstProduct()));
		addCart.clickFirstProduct().click();
		log.debug("Clicked on first product");

	}

	@And("^add that product to cart$")
	public void add_that_product_to_cart() throws Throwable {
		
		addCart.addToCart().click();
		log.debug("Clicked on add to cart button");
		
	}
}
