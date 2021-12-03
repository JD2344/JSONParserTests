package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import json.JSONBoolean;
import json.JSONFactory;

/**
 * Tests functionality of the {@link JSONBoolean} class
 * @author James Davis - c3576413
 *
 */
public class BooleanTests {
	/**
	 * Tests the {@link JSONBoolean} constructor
	 */
	@DisplayName("Test of all boolean initializers")
	@Test
	public void testBooleanInit() {
		JSONBoolean firstVal = JSONFactory.createBoolean(false);
		
		assertTrue(firstVal instanceof JSONBoolean);
		assertTrue(firstVal.isBoolean());
		assumeTrue(firstVal.asBoolean() == false);
		assumeFalse(firstVal.asBoolean() == true);
	}
	
	/**
	 * Checks that the toString() Method works
	 */
	@DisplayName("Test of to string methods")
	@Test
	public void testToString() {
		JSONBoolean firstVal = JSONFactory.createBoolean(false);
		JSONBoolean secondVal = JSONFactory.createBoolean(true);
		assertEquals(firstVal.toString(), "false");
		assumeTrue(firstVal.toString() != "true");
		
		assertEquals(secondVal.toString(), "true");
		assumeTrue(firstVal.toString() == "false");
	}
	
	/**
	 * Provides test for {@link JSONBoolean} asBoolean()
	 */
	@DisplayName("Test object conversions as boolean")
	@ParameterizedTest
	@ValueSource(booleans = { true, false })
	public void testAsBoolean(boolean testVal) {
		JSONBoolean boolVal = JSONFactory.createBoolean(testVal);
		assertTrue(boolVal.asBoolean() == testVal);
	}
	
	/**
	 * Test the {@link JSONBoolean} hashcode functionality
	 */
	@DisplayName("Test hascodes of boolean Class")
	@Test
	public void testHashCodes() {
		JSONBoolean firstBool = JSONFactory.createBoolean(true);
		JSONBoolean secondBool = JSONFactory.createBoolean(false);
		
		assertTrue(firstBool.hashCode() == 1231);
		assertTrue(secondBool.hashCode() == 1237);
	}
	
	/**
	 * Test the {@link JSONBoolean} equals method
	 */
	@DisplayName("Test the boolean equals method")
	@RepeatedTest(5)
	public void testEquals() {
		JSONBoolean falseB = JSONFactory.createBoolean(false);
		JSONBoolean duplicateF = JSONFactory.createBoolean(false);

		JSONBoolean trueB = JSONFactory.createBoolean(true);
		JSONBoolean duplicateT = JSONFactory.createBoolean(true);
		assumeTrue(falseB.equals(duplicateF));
		assumeTrue(trueB.equals(duplicateT));
		assumeFalse(falseB.asBoolean() == true);
	}
}
