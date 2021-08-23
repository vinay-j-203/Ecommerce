package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class AllCategoriesBrokenLinks extends Base {
	public WebDriver driver;

	@FindBy(xpath = "//li[@class='dropdown']//a[contains(text(),'View All Categories')]")
	private WebElement Allcategoriesclick;

	@FindBy(tagName = "a")
	private WebElement getAllLinks;

	public AllCategoriesBrokenLinks(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement Allcategoriesclick() throws InterruptedException {

		Allcategoriesclick.click();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		Boolean element = wait.until(ExpectedConditions.urlContains("all-categories"));
		System.out.println("Title of the page" + driver.getTitle());
		return Allcategoriesclick;

	}

	public WebElement getAllAnchorTags() {

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		List<String> urlList = new ArrayList<String>();

		for (WebElement link : links) {
			String fullurl = link.getAttribute("href");

			urlList.add(fullurl);

		}
		urlList.parallelStream().forEach(link -> getBrokenLink(link));
		return getAllLinks;
	}

	public static void getBrokenLink(String linkURL) {

		try {
			URL url = new URL(linkURL);
			HttpURLConnection httpURLConnectction = (HttpURLConnection) url.openConnection();
			httpURLConnectction.setConnectTimeout(3000);
			httpURLConnectction.connect();
			if (httpURLConnectction.getResponseCode() >= 400) {
				System.out.println(url + "is broken");
			} else {
				System.out.println(url + "is valid" + "with response code=" + httpURLConnectction.getResponseCode()
						+ httpURLConnectction.getResponseMessage());
			}

		}

		catch (Exception e) {

		}

	}

}