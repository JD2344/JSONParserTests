package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONFactory;
import json.JSONNull;
import json.JSONObject;
import json.JSONValue;

/**
 * Tests functionality present within the {@link JSONNull} class.
 * @author James Davis - c3576413
 *
 */
public class NullTests {
	private static JSONNull nullVal;
	private static String nullstring;
	private static final int hashVal = 953;
	
	@BeforeAll
	public static void buildObjects() {
		nullVal = JSONNull.JSON_NULL;
		nullstring = "null";
	}
	
	/**
	 * Test isNull
	 */
	@Test
	public void testIsNull() {
		assertTrue(nullVal.isNull());
		assertEquals(nullVal, JSONNull.JSON_NULL);
	}
	
	/**
	 * Test the tostring method of the {@link JSONNull} class
	 */
	@RepeatedTest(5)
	public void testToString() {
		if(nullVal.toString() == nullstring) {
			assertTrue(nullVal.toString() == nullstring);			
		}
		else 
		{
			fail("The tostring value did not match");
		}
	}
	
	/**
	 * Test the Hashcode method of the {@link JSONNull} class
	 */
	@RepeatedTest(5)
	public void testHashCode() {
		if(nullVal.hashCode() == hashVal) {
			assertTrue(nullVal.hashCode() == hashVal);			
		} 
		else 
		{
			fail("Hashcode did not match: " + hashVal);
		}
	}
	
	/**
	 * Tests the equals function of the {@link JSONNull} class
	 */
	@Test
	public void testEquals() {
		
	}
	
	@Test
	public void testAppend() {
		JSONValue testArray = JSONFactory.createArray();
		JSONObject testObject = JSONFactory.createObject();
		
	}
}
