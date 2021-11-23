package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

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
			e.printStackTrace();
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
	public void testAddMember() {
		JSONObject objWNull = JSONFactory.createObject();
		objWNull.addMember("isPresent");
		
		assertEquals(objWNull.toString(), "{\"isPresent\":null}");
		assertTrue(objWNull.hasMember("isPresent"));
		assumeFalse(objWNull.hasMember("testmember"));
		
		JSONObject objFBool = JSONFactory.createObject();
		objFBool.addMember("isPresent", false);
		
		assertTrue(objFBool.hasMember("isPresent"));
		assertTrue(objFBool.hasBooleanMember("isPresent") == false);
		
		JSONObject objTBool = JSONFactory.createObject();
		objTBool.addMember("isPresent", true);
		
		assertTrue(objFBool.hasBooleanMember("isPresent") == true);
		assertTrue(objTBool.hasMember("isPresent"));
		
		
	}
}
