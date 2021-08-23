package parallel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.PLP;
import resources.Base;

public class PLPTest extends Base {
	private static Logger log = (Logger) LogManager.getLogger(PLPTest.class.getName());
	private PLP listing = new PLP(driver);

	@Then("^navigate to category page$")
	public void navigate_to_category_page() throws Throwable {
		WebElement viewallcat = listing.getAllCategories();
		WebElement lp1 = listing.getParentCategory();
		WebElement lp2 = listing.getChildCategory();

		Actions actions = new Actions(driver);
		actions.moveToElement(viewallcat).build().perform();
		log.debug("Moved to all cat");

		actions.moveToElement(lp1).build().perform();
		log.debug("Moved to Parent Cat");

		actions.moveToElement(lp2).build().perform();
		log.debug("Moved to Child Cat");

		lp2.click();
		log.debug("Clicked in child cat");

	}

	@And("^capture the page title$")
	public void capture_the_page_title() throws Throwable {

		String catPageTitle = listing.getPageTitle();
		Assert.assertTrue(catPageTitle.contains("| ShakeDeal"));
		log.info("PLP page title grabed successfully");
	}

}
