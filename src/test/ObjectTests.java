package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONObject;

/**
 * Provides tests for the {@link JSONObject} class
 * 
 * @author james
 *
 */
public class ObjectTests {

	/**
	 * Tests the constructors for the {@link JSONObject} class
	 */
	@Test
	public void testConstructors() {
		JSONObject member = JSONFactory.createObject();
		member.addMember("key", false);
		JSONObject firstObj = JSONFactory.createObject();
		JSONObject secondObj = JSONFactory.createObject(firstObj);
		JSONObject thirdObj = JSONFactory.createObject(member);

		assertTrue(firstObj instanceof JSONObject);
		assertTrue(secondObj instanceof JSONObject);
		assertTrue(thirdObj instanceof JSONObject);

	}

	@Test
	public void testAsObject() {
		JSONObject object = JSONFactory.createObject();
		try {
			object.asObject();
		} catch (JSONException e) {
			
		}
	}
}
