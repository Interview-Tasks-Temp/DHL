package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Martin Dimitrov
 *
 */
public final class BrowserFactory {

	private BrowserFactory() {}

	public static WebDriver createNew(String browser) {

		String type = browser.toLowerCase().replaceAll("\\s+", "");

		switch (type) {

			case "chrome":

				return new ChromeDriver();

			case "firefox":

				// return WD FireFox instance

			case "opera":

				// return WD Opera instance

			case "ie":

				// return WD IE instance

			case "safari":

				// return WD Safari instance

			default:

				return null;

		}

	}

}