package parallel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AllCategoriesBrokenLinks;
import resources.Base;

public class AllCategoriesBrokenLinksstepDefinationTest extends Base {
	private static Logger log = (Logger) LogManager
			.getLogger(AllCategoriesBrokenLinksstepDefinationTest.class.getName());

	AllCategoriesBrokenLinks brokenLinks = new AllCategoriesBrokenLinks(driver);

	@When("^user is on landing page$")
	public void user_is_on_landing_page() throws Throwable {

	
		driver.getTitle();
		log.info("user is on landing page and title is captured");

	}

	@And("^clicks on all categories link which  navigates to all categories page$")
	public void clicks_on_all_categories_link_which_navigates_to_all_categories_page() throws Throwable {

		brokenLinks.Allcategoriesclick();
		log.debug("Clicked on all cat and navigated successfully capturing the page title");

	}	

	@And("^check for broken links$")
	public void check_for_broken_links() throws Throwable {

		brokenLinks.getAllAnchorTags();

		log.debug("all url's are validated");
	}
}
