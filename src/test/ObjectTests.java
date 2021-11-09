package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONFactory;
import json.JSONObject;

/**
 * Provides tests for the {@link JSONObject} class
 * @author james
 *
 */
public class ObjectTests {
	
	/**
	 * Tests the constructors for the {@link JSONObject} class
	 */
	@Test
	public void testConstructors() {
		JSONObject firstObj = JSONFactory.createObject();
		JSONObject secondObj = JSONFactory.createObject(firstObj);
		
		assertTrue(firstObj instanceof JSONObject);
		assertTrue(secondObj instanceof JSONObject);
	}
}
