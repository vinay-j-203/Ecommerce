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
import pageObjects.HomePageFooterLinks;
import resources.Base;

public class FooterLinksBrokenTest extends Base {
	private static Logger log = (Logger) LogManager
			.getLogger(FooterLinksBrokenTest.class.getName());

	HomePageFooterLinks brokenLinks = new HomePageFooterLinks(driver);
	@And("^check for broken links in footer$")
    public void check_for_broken_links_in_footer() throws Throwable {
		brokenLinks.getAllAnchorTags();
		log.debug("all footer url's are validated");
    }
}
