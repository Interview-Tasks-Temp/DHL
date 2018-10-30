# DHL
## Task
**1.** `Please review the attached Login form and write down as many Test scenarios as you can think of. Alternatively, you can visit the following link:`[https://s1.demo.opensourcecms.com/wordpress/wp-login.php](https://s1.demo.opensourcecms.com/wordpress/wp-login.php)

**2.** `Please write down Test cases for the aforementioned Test scenarios and automate them (using a tool of your choice)`

## Implementation
#### Simple single- threaded framework for UI test automation created with:
* Java 7
* Selenium 3.14
* Selenium Chrome 3.14
* Chrome Driver 2.43
* JUnit 4.12
* Maven 4.0
* Eclipse SimRel

#### Supported Operating Systems
Windows

#### Supported Browsers
Chrome

## Usage

Test Case classes are located in `src/test/java/tests`

Run As JunitTest:
  * `LoginPageExistingUserTests`
  * `LoginPageFieldValidationTests`
  * `LoginPageNonExistingUserTests`

## Easy Upgrade
Multi- platform support snippet:
```java
private static final String OS = System.getProperty("os.name").toLowerCase();

public static void init() {

	if (OS.indexOf("win") >= 0) {
	
		// Set up for Windows

	} else if (OS.indexOf("mac") >= 0) {

		// Set up for Mac

	} else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
	
		// Set up for Linux
		
	} else {

		// throw something like UnsupportedSystemException
		
	}
	
}
```

Multi- browser support snippet:
```java
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
```

Parallel execution snippet:
```java
public void executeTests() {

	@SuppressWarnings("rawtypes")
	Class[] testCaseClasses = { /** TestCases1.class, TestCases2.class **/ };

	// Parallel among classes
	JUnitCore.runClasses(ParallelComputer.classes(), testCaseClasses);

	// Parallel among methods in a class
	JUnitCore.runClasses(ParallelComputer.methods(), testCaseClasses);

	// Parallel all methods in all classes
	JUnitCore.runClasses(new ParallelComputer(true, true), testCaseClasses);

}
```



## Test Cases

#### Existing user

**1.** Verify an existing user is able to log in to the system with a correct user name and a correct password.  
**2.** Verify an existing user is able to log in to the system with a correct email address and a correct password.  
**3.** Verify an existing user is NOT able to log in to the system with a correct user name and incorrect password.  
**4.** Verify an existing user is NOT able to log in to the system with a correct email address and incorrect password.  
**5.** Verify an existing user is NOT able to log in to the system with a correct user name and no password.  
**6.** Verify an existing user is NOT able to log in to the system with a correct email address and no password.  

#### Non- existing user

**7.** Verify a user is NOT able to log in to the system without providng any credentials.  
**8.** Verify a non- existing user is NOT able to log in to the system with a valid user name and a valid password.  
**9.** Verify a non- existing user is NOT able to log in to the system with a valid email address and a valid password.  
**10.** Verify a non- existing user is NOT able to log in to the system with a valid user name and no password.  
**11.** Verify a non- existing user is NOT able to log in to the system with a valid email address and no password.  
**12.** Verify a non- existing user is NOT able to log in to the system with no user name/ email and a valid password.  

#### Field Validation

**13.** Verify an error message is shown when the user name has an incorrect format.  
**14.** Verify an error message is shown when the email address has an incorrect format.  

#### Autologin

**15.** Verify a user is presented with the Home page once he/ she has already logged into the system with "Remember me" checked.  

#### Lost Password
**16.** Verify an error message is shown when the user name has an incorrect format.  
**17.** Verify an error message is shown when the email address has an incorrect format.  
**18.** Verify an error message is shown when no user name/ email address field is left blank.  
**19.** Verify an existing user is NOT able to log in to the system with his/ hers old password.  

#### Others
and many more... like password encryption on DB level, are password chars hidden/ masked, etc.




