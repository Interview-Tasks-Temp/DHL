package pages;

import org.openqa.selenium.WebDriver;

import constants.Constants;

/**
 * Base Page Object (Facade layer)
 * @author Martin Dimitrov
 *
 */
public class BasePage {
	
	private final String baseUrl = Constants.BASE_URL;
	
	private WebDriver driver;
	
	private String url;
	
	public BasePage(WebDriver driver, String path) {
		this.driver = driver;
		this.url = baseUrl + path;
	}
	
	public void goTo() {
		driver.get(url);
	}
	
	public boolean isCurrentPage() {
		return (driver.getCurrentUrl() == url);
	}
	
	public boolean containsText(String text) {
		return driver.getPageSource().contains(text);
	}

}
