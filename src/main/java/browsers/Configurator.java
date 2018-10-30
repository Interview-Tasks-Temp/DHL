package browsers;

import constants.Constants;

/**
 * 
 * @author Martin Dimitrov
 *
 */
public final class Configurator {

	private static final String OS = System.getProperty("os.name").toLowerCase();

	private Configurator() {}

	public static void init() {

		if (OS.indexOf("win") >= 0) {

			System.setProperty(Constants.CHROME_SYS_KEY, Constants.CHROME_WIN);

		} else if (OS.indexOf("mac") >= 0) {

			// Set up for Mac

		} else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {

			// Set up for Linux

		} else {

			// throw something like UnsupportedSystemException

		}

	}

}
