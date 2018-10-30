package tests;

import static org.junit.Assert.assertTrue;

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
public class LoginPageFieldValidationTests extends LoginPageBaseTest {
	
	@Parameters
	public static Iterable<? extends Object> invalidEmails() {
	    return Arrays.asList("#@%^%#$@#$@#.com",
	    		"@domain.com",
	    		"Joe Smith <email@domain.com>",
	    		"email.domain.com",
	    		"email@domain@domain.com",
	    		".email@domain.com",
	    		"email.@domain.com",
	    		"email..email@domain.com",
	    		"あいうえお@domain.com",
	    		"email@domain.com (Joe Smith)",
	    		"email@domain",
	    		"email@-domain.com",
	    		"email@domain.webv",
	    		"email@111.222.333.44444",
	    		"email@domain..com");
	}
	
	@Parameter
	public String invalidEmail;
	
	/**
	 * Verify email field validation detects invalid email formats
	 * 
	 * 1. Go to Login page
	 * 2. Set <invalidEmail> as a value for the email field
	 * 3. Set "validPassword" as a value for the password field
	 * 4. Press Submit
	 * 5. The following message should be presented- Invalid email address
	 */
	@Test
	public void testEmailFieldValidation() {
		loginPage.setUser(invalidEmail);
		loginPage.setPassword("validPassword");
		loginPage.submit();
		assertTrue(loginPage.containsText("Invalid email address"));
		// Log failed validation emails
	}
	
}