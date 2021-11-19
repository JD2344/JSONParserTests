package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	@Test
	public void testBooleanInit() {
		JSONBoolean firstVal = JSONFactory.createBoolean(false);
		
		assertTrue(firstVal instanceof JSONBoolean);
		assertTrue(firstVal.isBoolean());
	}
	
	/**
	 * Checks that the toString() Method works
	 */
	@Test
	public void testToString() {
		JSONBoolean firstVal = JSONFactory.createBoolean(false);
		JSONBoolean secondVal = JSONFactory.createBoolean(true);
		assertEquals(firstVal.toString(), "false");
		assertEquals(secondVal.toString(), "true");
	}
	
	/**
	 * Provides test for {@link JSONBoolean} asBoolean()
	 */
	@ParameterizedTest
	@ValueSource(booleans = { true, false })
	public void testAsBoolean(boolean testVal) {
		JSONBoolean boolVal = JSONFactory.createBoolean(testVal);
		assertTrue(boolVal.asBoolean() == testVal);
	}
	
	/**
	 * Test the {@link JSONBoolean} hashcode functionality
	 */
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
	@Test
	public void testEquals() {
		JSONBoolean falseB = JSONFactory.createBoolean(false);
		JSONBoolean duplicateF = JSONFactory.createBoolean(false);

		JSONBoolean trueB = JSONFactory.createBoolean(true);
		JSONBoolean duplicateT = JSONFactory.createBoolean(true);
		assertTrue(falseB.equals(duplicateF));
		assertTrue(trueB.equals(duplicateT));
	}
}
