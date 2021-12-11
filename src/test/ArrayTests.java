package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import json.JSONArray;
import json.JSONBoolean;
import json.JSONException;
import json.JSONFactory;
import json.JSONNull;
import json.JSONNumber;
import json.JSONObject;
import json.JSONParser;
import json.JSONString;
import json.JSONValue;

/**
 * Tests all functionality of the {@link JSONArray} class
 * 
 * @author James Davis - c3576413
 *
 */
public class ArrayTests {
	/**
	 * A default array of values
	 */
	private static JSONArray testingArray;

	/**
	 * Builds a new {@link JSONArray} with values of all types
	 */
	ArrayTests() {
		JSONArray finishedA = JSONFactory.createArray(10);
		finishedA.addValue(false);
		finishedA.addValue(true);
		finishedA.addValue(10.2);
		finishedA.addValue(22.3f);
		finishedA.addValue(JSONFactory.createArray());
		finishedA.addValue(JSONFactory.createObject());
		finishedA.addValue(21475963l);
		finishedA.addValue("hello");
		finishedA.addValue();
		ArrayTests.testingArray = finishedA;
	}

	/**
	 * Tests the constructors of the {@link JSONArray} class
	 */
	@DisplayName("Test of all array initializers")
	@Test
	public void testArrayInits() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray secondA = JSONFactory.createArray(10);
		secondA.addValue(false);

		JSONArray lastA = JSONFactory.createArray(secondA);

		assertTrue(firstA instanceof JSONArray);
		assertTrue(firstA.isArray());
		assertTrue(secondA instanceof JSONArray);
		assertEquals(secondA.size(), 1);
		assertEquals(secondA.get(0), JSONBoolean.JSON_FALSE);

		assertTrue(lastA instanceof JSONArray);
		assertEquals(lastA, secondA);
	}

	/**
	 * Tests some of the basic functions of the {@link JSONArray} class
	 */
	@DisplayName("Test of all array methods")
	@RepeatedTest(5)
	public void testArrayMethods() {
		JSONArray firstA = JSONFactory.createArray();
		JSONArray copyA = firstA.copy();
		JSONArray thirdA = JSONFactory.createArray();
		thirdA.addValue(false);

		assertTrue(firstA.isArray());
		assertEquals(firstA, copyA);
		assertTrue(firstA.equals(copyA));
		assertEquals(firstA.hashCode(), copyA.hashCode());

		assertEquals(firstA.toString(), "[]");
		assertEquals(thirdA.toString(), "[false]");
	}
	
	@RepeatedTest(3)
	public void testHashCode() {
		//Hash: 1268
		JSONArray ja = JSONFactory.createArray();
		ja.addValue(false);
		assertTrue(ja.hashCode() == 1268);
	}
	
	/**
	 * Sloppy way to test adding {@link JSONValue} to an 
	 * array
	 */
	@Test
	public void testAddJSONVal() {
		JSONArray a = JSONFactory.createArray();
		
		try {
			JSONValue val = JSONParser.parse("10");
			a.addValue(val);
			
			assertTrue(a.get(0).asInteger() == 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Provides testing functionality for the {@link JSONArray} .add() methods
	 * NOTE: This also covers the {@link JSONValue} appendTo functionality
	 * for each value type
	 */
	@DisplayName("Test of adding values into arrays")
	@Test
	public void testAddValueMethods() {
		for (int index = 0; index < testingArray.size(); index++) {
			
			try {
				JSONValue value = testingArray.get(index);
				
				if (value.isNull()) {
					assertTrue(value instanceof JSONNull);					
				}
				
				if (value.isObject()) {
					assertTrue(value instanceof JSONObject);
					assertEquals(value.asObject(), testingArray.get(index).asObject());					
				}
				
				if (value.isArray()) {
					assertTrue(value instanceof JSONArray);
					assertEquals(value.asArray(), testingArray.get(index).asArray());
				}
				
				if (value.isBoolean()) {
					assertTrue(value instanceof JSONBoolean);	
					assertEquals(value.asBoolean(), testingArray.get(index).asBoolean());				
				}
				
				if (value.isNumber()) {
					assertTrue(value instanceof JSONNumber);
					
					//TODO:Potentially check all numbers and verify return val
					/*JSONValue num = testingArray.get(index);
					try {
						num.as
					} catch (JSONException e) {
						
					}*/
				}
				
				if (value.isString()) {
					assertTrue(value instanceof JSONString);	
					assertEquals(value.asString(), testingArray.get(index).asString());								
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
	}
}
