package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Martin Dimitrov
 *
 */
public class LoginPageNonExistingUserTests extends LoginPageBaseTest {

	/**
	 * Verify a user is NOT able to log in to the system 
	 * without providng any credentials.
	 * 
	 * 1. Go to Login page
	 * 2. Leave the user/ email field blank
	 * 3. Leave the password field blank
	 * 4. Press Submit
	 * 5. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_NoUser_NoPassword() {
		loginPage.submit();
		assertTrue(loginPage.isCurrentPage());
	}
	
	/**
	 * Verify a non- existing user is NOT able to log in to the system 
	 * with a user name and a password which both passes field validation criteria
	 * 
	 * 1. Go to Login page
	 * 2. Set "validUserName" as a value for the user field
	 * 3. Set "validPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. The following error message should be presented "Invalid username"
	 */
	@Test
	public void test_Login_ValidUser_ValidPassword() {
		loginPage.setUser("validUserName");
		loginPage.setPassword("validPassword");
		loginPage.submit();
		assertTrue(loginPage.containsText("Invalid username"));
	}
	
	/**
	 * Verify a non- existing user is NOT able to log in to the system 
	 * with an email and a password which both passes field validation criteria
	 * 
	 * 1. Go to Login page
	 * 2. Set "validEmail@validDomain.com" as a value for the email field
	 * 3. Set "validPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. The following error message should be presented "Invalid username"
	 */
	@Test
	public void test_Login_ValidEmail_ValidPassword() {
		loginPage.setUser("validEmail@validDomain.com");
		loginPage.setPassword("validPassword");
		loginPage.submit();
		assertTrue(loginPage.containsText("Invalid username"));
	}
	
	/**
	 * Verify a non- existing user is NOT able to log in to the system 
	 * with a user name which passes field validation criteria and no password.
	 * 
	 * 1. Go to Login page
	 * 2. Set "validUserName" as a value for the user field
	 * 3. Leave the password field blank
	 * 4. Press Submit
	 * 5. The following error message should be presented "The password field is empty"
	 * 6. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_ValidUser_NoPassword() {
		loginPage.setUser("validUserName");
		loginPage.submit();
		assertTrue(loginPage.containsText("The password field is empty"));
		assertTrue(loginPage.isCurrentPage());
	}
	
	/**
	 * Verify a non- existing user is NOT able to log in to the system 
	 * with an email which passes field validation criteria and no password.
	 * 
	 * 1. Go to Login page
	 * 2. Set "validEmail@validDomain.com" as a value for the email field
	 * 3. Leave the password field blank
	 * 4. Press Submit
	 * 5. The following error message should be presented "The password field is empty"
	 * 6. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_ValidEmail_NoPassword() {
		loginPage.setUser("validEmail@validDomain.com");
		loginPage.submit();
		assertTrue(loginPage.containsText("The password field is empty"));
		assertTrue(loginPage.isCurrentPage());
	}
	
	/**
	 * Verify a non- existing user is NOT able to log in to the system 
	 * with no user name/ email and a password which passes field validation criteria
	 * 
	 * 1. Go to Login page
	 * 2. Leave the user/ email field blank
	 * 3. Set "validPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. The following error message should be presented "The username field is empty"
	 * 6. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_NoUser_ValidPassword() {
		loginPage.setPassword("validPassword");
		loginPage.submit();
		assertTrue(loginPage.containsText("The username field is empty"));
		assertTrue(loginPage.isCurrentPage());
	}
	
}
