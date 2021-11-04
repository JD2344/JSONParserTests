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
	
}
