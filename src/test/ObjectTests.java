package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import json.JSONException;
import json.JSONFactory;
import json.JSONObject;
import json.JSONParser;

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

	/**
	 * Test the AsObject Method
	 */
	@Test
	public void testAsObject() {
		JSONObject object = JSONFactory.createObject();
		try {
			JSONObject copy = object.asObject();
			assertEquals(object, copy);
		} catch (JSONException e) {
			
		}
	}
	
	@Test
	public void testToString() {
		String object = "{\"isHere\":true}";
		//TODO: maybe add whitespace check "{ \"isHere\":true }" <- this breaks it....
		try {
			JSONObject testVal = JSONParser.parse(object).asObject();
			System.out.println(testVal + " " + object.toString());
			assertEquals(testVal.toString(), object.toString());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddStringMember() {
		JSONObject o = JSONFactory.createObject();
		
	}
}
