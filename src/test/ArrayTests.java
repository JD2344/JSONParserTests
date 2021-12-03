package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	private JSONArray testingArray;

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
		this.testingArray = finishedA;
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
	@Test
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

	/**
	 * Provides testing functionality for the {@link JSONArray} .add() methods
	 */
	@DisplayName("Test of adding values into arrays")
	@Test
	public void testAddValueMethods() {
		for (int index = 0; index < testingArray.size(); index++) {
			
			try {
				JSONValue value = testingArray.get(index);
				System.out.println(value.toString());
				
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
