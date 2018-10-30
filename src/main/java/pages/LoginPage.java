package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Martin Dimitrov
 *
 */
public final class LoginPage extends BasePage {
	
	private final static String PATH = "/wp-login.php";
	
	private WebDriver driver;
		
	@FindBy(id = "user_login")
	private WebElement user;
	
	@FindBy(id = "user_pass")
	private WebElement password;
	
	@FindBy(id = "rememberme")
	private WebElement autologin;
	
	@FindBy(id = "wp-submit")
	private WebElement submit;
	
	@FindBy(linkText = "Lost your password?")
	private WebElement lostPassword;
	
	public LoginPage(WebDriver driver) {
		super(driver, PATH);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void setUser(String user) {
		this.user.sendKeys(user);
	}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void enableAutologin() {
		autologin.click();
	}
	
	public void submit() {
		submit.click();
	}
	
	public void goToLostPassword() {
		lostPassword.click();
	}

}
