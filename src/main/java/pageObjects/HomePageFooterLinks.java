package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePageFooterLinks extends Base {

	public WebDriver driver;

	@FindBy(css = "div.row.footer-theme.partition-f")
	private WebElement FooterLinks;


	public HomePageFooterLinks(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement getFooterLinks() {

		return FooterLinks;
	}

	public WebElement getAllAnchorTags() {

		WebElement footerLinks = driver.findElement(By.cssSelector("div.row.footer-theme.partition-f"));
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
		
		List<WebElement> footerLinks1 = footerLinks.findElements(By.tagName("a"));
		
		
		List<String> urlList = new ArrayList<String>();

		for (WebElement link : footerLinks1) {
			String fullurl = link.getAttribute("href");

			urlList.add(fullurl);

		}
		urlList.parallelStream().forEach(link -> getBrokenLink(link));
		return FooterLinks;
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
