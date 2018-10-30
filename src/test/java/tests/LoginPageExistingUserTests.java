package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Martin Dimitrov
 *
 */
@RunWith(Parameterized.class)
public class LoginPageExistingUserTests extends LoginPageBaseTest {
	
	/**
	 * Insert test data into the database or make registration through the UI flow
	 * in order to have an existing account with username/email and password
	 * so they can be used in this test
	 */
	
	/**
	 * user defined name and email
	 */
	@Parameters
	public static Iterable<? extends Object> exsistingUserNameAndEmail() {
	    return Arrays.asList("correctUserName", "correctEmail@correctDomain.com");
	}
	
	@Parameter
	public String credential;
	
	/** 
	 * @Will run 2 times
	 * 
	 * Verify an existing user is able to log in to the system 
	 * with a correct user name/ email and a correct password.
	 * 
	 * 1. Go to Login page
	 * 2. Set <credential> as a value for the user/ email field
	 * 3. Set "correctPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. Home page should be loaded and visible
	 */
	@Test
	public void test_Login_CorrectUser_CorrectPassword() {
		loginPage.setUser(credential);
		loginPage.setPassword("correctPassword");
		loginPage.submit();
		fail("Intentionally Failed Test -> 1. Missing Credentials 2. Missing Home Page address");
	}
	
	/**
	 * @Will run 2 times
	 * 
	 * Verify an existing user is NOT able to log in to the system 
	 * with a correct user name/ email and incorrect password.
	 * 
	 * 1. Go to Login page
	 * 2. Set <credential> as a value for the user/ email field
	 * 3. Set "incorrectPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. An error message should be shown, something like "Incorrect password!"
	 * 6. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_CorrectUser_IncorrectPassword() {
		loginPage.setUser(credential);
		loginPage.setPassword("incorrectPassword");
		loginPage.submit();
		fail("Intentionally Failed Test -> Missing an existing user name/ email");
	}
	
	/**
	 * @Will run 2 times
	 * 
	 * Verify an existing user is NOT able to log in to the system 
	 * with a correct user name/ email and no password
	 * 
	 * 1. Go to Login page
	 * 2. Set <credential> as a value for the user/ email field
	 * 3. Leave the password field blank
	 * 4. Press Submit
	 * 5. The following error message should be presented "The password field is empty"
	 * 6. Login page should be still loaded and visible
	 */
	@Test
	public void test_Login_CorrectUser_NoPassword() {
		loginPage.setUser(credential);
		loginPage.submit();
		assertTrue(loginPage.containsText("The password field is empty"));
		assertTrue(loginPage.isCurrentPage());
	}

}
