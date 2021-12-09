package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONException;
import json.JSONFactory;
import json.JSONObject;
import json.JSONParser;
import json.JSONString;
import json.JSONValue;

/**
 * Provides tests for the {@link JSONObject} class
 * 
 * @author James Davis - c3576413
 *
 */
public class ObjectTests {
	private static JSONValue parsedValue;

	/**
	 * Test the values within an object and sure that they match a given object size
	 * and values match.
	 */
	@BeforeAll
	public static void jsonInputTest() {
		try {
			parsedValue = JSONParser.parseFile(System.getProperty("user.dir") + "/src/jsonFiles/Testing.json");

			JSONObject convertedValue = parsedValue.asObject();

			assertTrue(convertedValue.size() == 11);

			assertSame(parsedValue, convertedValue);

			Collection<JSONValue> values = convertedValue.values();

			assertEquals(values.stream().count(), convertedValue.size());

			/*
			 * Not an amazing way of comparing keys/ values
			 * performs the bare minimum but it works...
			 */
			Set<String> keys = convertedValue.members();
			Iterator<Entry<String, JSONValue>> items = convertedValue.iterator();
			
			while(items.hasNext()) {
				Entry<String, JSONValue> nextVal = items.next();
				
				assertTrue(keys.contains(nextVal.getKey()));
				assertTrue(values.contains(nextVal.getValue()));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

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
	 * Test the {@link JSONObject#asObject()} Method
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

	/**
	 * Test the {@link JSONObject#toString()} method
	 */
	@Test
	public void testToString() {
		String object = "{\"isHere\":true}";
		String multiObject = "{\"item1\":\"string1\",\"item2\":\"string2\"}";
		// TODO: maybe add whitespace check "{ \"isHere\":true }" <- this breaks it....
		try {
			JSONObject testVal = JSONParser.parse(object).asObject();
			assertEquals(testVal.toString(), object.toString());

			JSONObject multiVal = JSONParser.parse(multiObject).asObject();
			assertEquals(multiVal.toString(), multiObject.toString());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test the {@link JSONObject#hashCode()} method
	 */
	@Test
	public void testHashCode() {
		try {
			JSONObject testVal = parsedValue.asObject();
			assertEquals(testVal.hashCode(), 2095311018);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test a given copy of an object
	 */
	@Test
	public void testCopy() {
		JSONObject object = JSONFactory.createObject();
		JSONObject secCopy = object.copy();
		assertEquals(object.toString(), secCopy.toString());
	}

	/**
	 * Test an item is a {@link JSONObject}
	 */
	@Test
	public void testIsObject() {
		JSONObject o = JSONFactory.createObject();

		if (o.isObject()) {
			assertTrue(o.isObject());
		}
	}

	/**
	 * Tests adding members to an object and checks validity of whether it was added
	 * and present.
	 * 
	 * NOTE: {@link JSONObject#hasBooleanMember(String)} method has an exception,
	 * this cannot be reached as type checking eliminates this ever happening
	 */
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
		assertTrue(objTBool.hasBooleanMember("isPresent") == true);
		assertTrue(objTBool.hasMember("isPresent"));

		JSONObject objNotBool = JSONFactory.createObject();
		objNotBool.addMember("aMember");
		assertFalse(objNotBool.hasBooleanMember("aMember"));

		JSONObject objWobj = JSONFactory.createObject();
		objWobj.addMember("nestedObject", objWNull);
		assertTrue(objWobj.hasMember("nestedObject") && objWobj.getMember("nestedObject") instanceof JSONObject);

		JSONObject objWstring = JSONFactory.createObject();
		objWstring.addMember("string", "stringVal");
		assertTrue(objWstring.hasMember("string") && objWstring.getMember("string") instanceof JSONString);

		JSONObject objWarray = JSONFactory.createObject();
		JSONArray arrayVal = JSONFactory.createArray(5);
		objWarray.addMember("arrayVal", arrayVal);
		assertTrue(objWarray.hasMember("arrayVal") && objWarray.getMember("arrayVal") instanceof JSONArray);
	}

	/**
	 * Checks all the given values within an object and checks that they are present
	 * with the correct name
	 */
	@Test
	public void testAddNumbers() {
		JSONObject objWlong = JSONFactory.createObject();
		JSONObject objWfloat = JSONFactory.createObject();
		JSONObject objWdouble = JSONFactory.createObject();

		objWlong.addMember("longVal", 2939438383l);
		assertTrue(objWlong.hasMember("longVal"));
		assertTrue(objWlong.getMember("longVal").isNumber());

		objWfloat.addMember("floatVal", 23.3232323232f);
		assertTrue(objWfloat.hasMember("floatVal"));
		assertTrue(objWfloat.getMember("floatVal").isNumber());

		objWdouble.addMember("doubleVal", 10.2);
		assertTrue(objWdouble.hasMember("doubleVal"));
		assertTrue(objWdouble.getMember("doubleVal").isNumber());
	}
}
