package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;

import browsers.BrowserFactory;
import browsers.Configurator;
import pages.LoginPage;

/**
 * 
 * @author Martin Dimitrov
 *
 */
@Ignore public class LoginPageBaseTest {

	static {
		Configurator.init();
	}
	
	protected WebDriver chrome;
	protected LoginPage loginPage;
	
	@Before
	public void before() {
		chrome = BrowserFactory.createNew("chrome");
		loginPage = new LoginPage(chrome);
		loginPage.goTo();
	}
	
	@After
	public void after() {
		chrome.quit();
	}
	
}
