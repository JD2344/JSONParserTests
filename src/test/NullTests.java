package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONNull;

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
		JSONNull nullVal = JSONFactory.createNull();
		assertTrue(nullVal.isNull());
	}
	
	/**
	 * Test the tostring method of the {@link JSONNull} class
	 */
	@Test
	public void testToString() {
		JSONNull nullVal = JSONFactory.createNull();
		
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
		JSONNull nullVal = JSONFactory.createNull();
		
		if(nullVal.hashCode() == 953) {
			assertTrue(nullVal.hashCode() == 953);			
		} 
		else 
		{
			fail("Hashcode did not match: 953");
		}
		
	}
	
	@Test
	public void testEquals() {
		
	}
}
