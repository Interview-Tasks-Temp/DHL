package executor;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

/**
 * 
 * @author Martin Dimitrov
 *
 */
public class ParallelExecutor {

	@Test
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

}