package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

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
	@Test
	public void testAsBoolean() {
		JSONBoolean testVal = JSONFactory.createBoolean(false);
		assertTrue(testVal.asBoolean() == false);
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
		JSONBoolean bool = JSONFactory.createBoolean(false);
		
	}
}
