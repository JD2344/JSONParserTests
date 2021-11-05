package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONFactory;
import json.JSONNull;
import json.JSONObject;

/**
 * Tests functionality present within the {@link JSONNull} class.
 * @author c3576413
 *
 */
public class NullTests {
	
	/**
	 * Test isNull
	 */
	@Test
	public void testIsNull() {
		JSONNull nullVal = JSONNull.JSON_NULL;
		assertTrue(nullVal.isNull());
		assertEquals(nullVal, JSONNull.JSON_NULL);
	}
	
	/**
	 * Test the tostring method of the {@link JSONNull} class
	 */
	@Test
	public void testToString() {
		JSONNull nullVal = JSONNull.JSON_NULL;
		
		if(nullVal.toString() == "null") {
			assertTrue(nullVal.toString() == "null");			
		}
		else 
		{
			fail("The tostring value did not match");
		}
	}
	
	/**
	 * Test the Hashcode method of the {@link JSONNull} class
	 */
	@Test
	public void testHashCode() {
		JSONNull nullVal = JSONNull.JSON_NULL;
		
		if(nullVal.hashCode() == 953) {
			assertTrue(nullVal.hashCode() == 953);			
		} 
		else 
		{
			fail("Hashcode did not match: 953");
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
		JSONArray testArray = JSONFactory.createArray();
		JSONObject testObject = JSONFactory.createObject();
		
		
	}
}
